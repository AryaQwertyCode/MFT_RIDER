package com.techcamino.mft_rider.activity

import android.Manifest
import android.app.AlertDialog
import android.app.Dialog
import android.content.*
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Color
import android.graphics.Matrix
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.provider.Settings.ACTION_MANAGE_ALL_FILES_ACCESS_PERMISSION
import android.service.controls.ControlsProviderService.TAG
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.annotation.RequiresApi
import androidx.appcompat.widget.Toolbar
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider
import androidx.exifinterface.media.ExifInterface
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.load.resource.bitmap.TransformationUtils.rotateImage
import com.google.android.material.snackbar.Snackbar
import com.techcamino.mft_rider.R
import com.techcamino.mft_rider.adapters.SubOrderAdapter
import com.techcamino.mft_rider.apis.ApiClient
import com.techcamino.mft_rider.apis.ApiInterface
import com.techcamino.mft_rider.databinding.ActivityReceiptBinding
import com.techcamino.mft_rider.models.MessageDetail
import com.techcamino.mft_rider.models.orders.Detail
import com.techcamino.mft_rider.models.orders.Order
import com.techcamino.mft_rider.models.orders.OrderDetail
import com.techcamino.mft_rider.models.orders.OrderInfo
import com.techcamino.mft_rider.permissionUtils.OnActivityResultListener
import com.techcamino.mft_rider.utils.ProgressDialog
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*


class ReceiptActivity : BaseActivity(), View.OnClickListener, OnActivityResultListener,
    SubOrderAdapter.OnItemClickListener {
    private lateinit var binding: ActivityReceiptBinding
    lateinit var shared: SharedPreferences
    lateinit var apiService: ApiInterface
    lateinit var phoneNumber: String
    lateinit var dialog: Dialog
    private lateinit var token: String
    private var order: Order.Result.Orders? = null
  //  private var subOrder: OrderDetail.Result.OrderInfo.Detail ? = null
    private var subOrder: Detail? = null
    private var pictureFilePath: String? = null
    private val MY_PERMISSIONS_REQUEST_CAMERA = 99
    private var isDelivered: Boolean = false
    private var imageView: ImageView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityReceiptBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var toolbar = findViewById<View>(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)

        try {
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
            supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back_ios_24)

        } catch (e: Exception) {
            e.printStackTrace()
        }
        dialog = ProgressDialog.progressDialog(this)
//        phoneNumber = intent.getStringExtra("mobile")!!


        apiService = ApiClient.apiInterface
        shared =
            getSharedPreferences(
                this@ReceiptActivity.resources.getString(R.string.app_name),
                Context.MODE_PRIVATE
            )
        token =
            shared.getString(this@ReceiptActivity.resources.getString(R.string.access_token), "")!!
        order = intent.getParcelableExtra<Order.Result.Orders>("order")
        Log.d("phonenumber", order?.address!!)

        onActivityResultListener = this
        binding.deliveredBtn.setOnClickListener(this)
        binding.helpNumber.setOnClickListener(this)
        getOrderDetail(token, order?.orderId!!)

    }

    // check permission
    @RequiresApi(Build.VERSION_CODES.R)
    private fun checkPermissions(permission: kotlin.String, requestCode: Int) {
        if (ContextCompat.checkSelfPermission(
                this,
                permission
            ) != PackageManager.PERMISSION_GRANTED
        ) {

            if (ActivityCompat.shouldShowRequestPermissionRationale(this, permission)) {
                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.
                AlertDialog.Builder(this)
                    .setTitle("Required Camera Permission")
                    .setMessage("You have to give this permission to access camera")
                    .setPositiveButton("OK",
                        DialogInterface.OnClickListener { _, i ->
                            ActivityCompat.requestPermissions(
                                this, arrayOf(Manifest.permission.CAMERA),
                                MY_PERMISSIONS_REQUEST_CAMERA
                            )
                        })
                    .setNegativeButton("Cancel", DialogInterface.OnClickListener { dialogInterface, i -> dialogInterface.dismiss() })
                    .create()
                    .show()
            } else {
                // take permission
                ActivityCompat.requestPermissions(this, arrayOf(permission), requestCode)

            }
        } else {

            if (this.packageManager.hasSystemFeature(PackageManager.FEATURE_CAMERA_ANY)) {

                clickPhoto(REQUEST_IMAGE_CAPTURE_WITHOUT_SCALE)

            } else {
                Toast.makeText(this, "No camera available on this device.", Toast.LENGTH_LONG).show()
            }
            //Toast.makeText(this,"Permission already granted", Toast.LENGTH_LONG).show()
        }
    }

    @RequiresApi(Build.VERSION_CODES.R)
    private fun getPictureFile(fileName: String, dirName: kotlin.String): File? {

        /*-------------------------------*/


       /* val timeStamp: String = SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())
        val storageDirOne: File = getExternalFilesDir(Environment.DIRECTORY_PICTURES)!!
        return File.createTempFile(
            "JPEG_${timeStamp}_", *//* prefix *//*
            ".jpg", *//* suffix *//*
            storageDirOne *//* directory *//*
        ).apply {
            // Save a file: path for use with ACTION_VIEW intents
            currentPhotoPath = absolutePath
        }*/



        /*------------------------------*/

        val diren = this.resources.getString(R.string.app_name)

       /* var image : File ? = null
        if (Environment.isExternalStorageManager()) {
            val storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES)
            val imagePath = File(storageDir, diren)
            Log.d("avinash", "Find " + imagePath.absolutePath)

            if (!imagePath.exists()) {
                if (!imagePath.mkdirs()) {
                    Log.d("CameraTestIntent", "failed to create directory");

                } else {
                    Log.d("tag", "create new Tux folder");
                }

            }

            // val imageName = subOrder?.subOrderId

            val imageName = subOrder?.subOrderId
            //val image = File(imagePath, "$imageName$fileName.jpg")
             image = File(imagePath, "$imageName$fileName.jpg")
            Log.d("image path", image.absolutePath)

            pictureFilePath = image.absolutePath

            return image
        } else {
            val permissionIntent = Intent(ACTION_MANAGE_ALL_FILES_ACCESS_PERMISSION)
            startActivity(permissionIntent)
        }*/

        val storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        val imagePath = File(storageDir, diren)
        Log.d("avinash", "Find " + imagePath.absolutePath)

        if (!imagePath.exists()) {

            if (!imagePath.mkdirs()) {
                Log.d("CameraTestIntent", "failed to create directory");

            } else {
                Log.d("tag", "create new Tux folder");
            }

        }

       // val imageName = subOrder?.subOrderId

        val imageName = subOrder?.subOrderId
       // val image = File(imagePath, "$imageName$fileName.jpg")
        val image = File.createTempFile( "$imageName$fileName", ".jpg")
        Log.d("image path", image.absolutePath)

        pictureFilePath = image.absolutePath

        return image

     //   return image

    }

    /**
     * testing image capture
     */
    @RequiresApi(Build.VERSION_CODES.R)
    private fun clickPhoto(requestCode: Int) {

        val takePictureIntent = Intent()

      //  val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        takePictureIntent.action = MediaStore.ACTION_IMAGE_CAPTURE


      /* if(takePictureIntent.resolveActivity(this.packageManager)!=null){*/

           takePictureIntent.resolveActivity(packageManager)?.also {
               // Create the File where the photo should go
               val photoFile: File? =
               try {
                   getPictureFile(subOrder?.subOrderId!!, "mft")
               } catch (ex: IOException) {

                   Toast.makeText(this, "${ex.message}", Toast.LENGTH_LONG).show()
                   Log.d(TAG, "clickPhoto:${ex.message}")
                   null

               }

               // Continue only if the File was successfully created
               photoFile?.also {

                   val photoURI: Uri = FileProvider.getUriForFile(
                       this,
                       "techcamino.mft_rider.provider",
                       it
                   )

                   mimeType = "image/*"
                   val values = ContentValues().apply {
                       put(MediaStore.Images.Media.DISPLAY_NAME, getNewFileName(order?.orderId!!))
                       put(MediaStore.Images.Media.MIME_TYPE, mimeType)
                       put(
                           MediaStore.Images.Media.RELATIVE_PATH,
                           getImageDirectoryPath(this@ReceiptActivity.resources.getString(R.string.app_name))
                       )
                   }

                   if (Build.VERSION.SDK_INT < Build.VERSION_CODES.R) {
                       takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI)
                       Log.d("into if", photoURI.toString())
                   } else {

                       val imageUri =
                           contentResolver.insert(
                               MediaStore.Images.Media.getContentUri(MediaStore.VOLUME_EXTERNAL),
                               values
                           )
                       Log.d("into elese", photoFile.toString())
                       if (imageUri != null) {
                           pictureFilePath = imageUri.toString()
                           shareUri = imageUri
                           Log.d("avinash", pictureFilePath!!)
                       }

                       takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri)
                   }
                   initRequestCode(takePictureIntent, requestCode)
               }

           }

       /*}else{
           Toast.makeText(this,"Could not flound application to capture the Photo",Toast.LENGTH_LONG).show()
       }*/

    }

    private fun initRequestCode(takePictureIntent: Intent, requestImageCapture: Int) {
        currentRequestCode = requestImageCapture
        startActivityForResult.launch(takePictureIntent)
    }


    override fun onActivityResult(
        result: ActivityResult,
        currentRequestCode: Int
    ) {
       // Log.d("testing file name", pictureFilePath!!)

        if (currentRequestCode == REQUEST_IMAGE_CAPTURE_WITHOUT_SCALE) {


            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.R) {
                val file = File(pictureFilePath!!)
                shareUri = FileProvider.getUriForFile(
                    this,
                    "techcamino.mft_rider.provider",
                    file
                )
            } else {
                var image: Bitmap = getBitmapFromContentResolver(Uri.parse(pictureFilePath))
            }
            val compressionRatio = 20 //1 == originalImage, 2 = 50% compression, 4=25% compress

//            val file: File = File(pictureFilePath)
//            try {
//                var bitmap = BitmapFactory.decodeFile(file.path)
//                bitmap = degreeRotate(rotation(bitmap, file), 0f)
//                bitmap.compress(
//                    Bitmap.CompressFormat.JPEG,
//                    compressionRatio,
//                    FileOutputStream(file)
//                )
//            } catch (t: Throwable) {
//                Log.e("ERROR", "Error compressing file.$t")
//                t.printStackTrace()
//            }


            if(!shareUri.toString().isNullOrEmpty()){

                Log.d("34245452", shareUri.toString())
                var image: Bitmap = getBitmapFromContentResolver(this!!.shareUri!!)

                var orientation: Int = if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.N){
                    getOrientation2(this!!.shareUri!!)
                }else{
                    getOrientation(this!!.shareUri!!)
                }

                val file = if(Build.VERSION.SDK_INT < Build.VERSION_CODES.R){
                    createImageFile("mft",subOrder?.subOrderId!! )
                }else{
                    Log.d("i am here"," find something")
                    //File("${Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES)}" + File.separator + "mft",getNewFileName(subOrder?.subOrderId!! ))
                    createImageFile("mft",subOrder?.subOrderId!! )
                }
                var fos: FileOutputStream = FileOutputStream(file)
                var bitmap = image

                Log.d(TAG, "Image Size:${bitmap.width} , ${bitmap.height}")

                if (orientation != -1 && orientation != 0) {

                    val matrix = Matrix()
                    if (orientation == 6) {
                        matrix.postRotate(60f)
                        Log.d("EXIF", "Exif: $orientation")
                    } else if (orientation == 3) {
                        matrix.postRotate(100f)
                        Log.d("EXIF", "Exif: $orientation")
                    } else if (orientation == 8) {
                        matrix.postRotate(180f)
                        Log.d("EXIF", "Exif: $orientation")
                    }else{
                        matrix.postRotate(orientation.toFloat())
                    }

                    bitmap = Bitmap.createBitmap(
                        bitmap, 0, 0,
                        bitmap.width, bitmap.height, matrix,
                        true
                    )

                }

                bitmap.compress(
                    Bitmap.CompressFormat.JPEG,
                    20,
                    fos
                )

                Log.d(TAG, "AfterCompressImage ${bitmap.compress( Bitmap.CompressFormat.JPEG,
                    20,
                    fos)}")

                uploadImage(
                    token,
                    subOrder?.subOrderId!!,
                    file
                )

            }

        }

    }
    private fun rotation(bitmap: Bitmap, file: File): Bitmap {
        val ei = ExifInterface(file.path)
        val orientation: Int = ei.getAttributeInt(
            ExifInterface.TAG_ORIENTATION,
            ExifInterface.ORIENTATION_NORMAL
        )

        return when (orientation) {
            ExifInterface.ORIENTATION_ROTATE_90 -> rotateImage(bitmap, 90)
            ExifInterface.ORIENTATION_ROTATE_180 -> rotateImage(bitmap, 180)
            ExifInterface.ORIENTATION_ROTATE_270 -> rotateImage(bitmap, 270)
            else -> bitmap
        }
    }

    private fun degreeRotate(img: Bitmap, degree: Float): Bitmap {
        val matrix = Matrix()
        matrix.postRotate(degree)
        val rotatedImg =
            Bitmap.createBitmap(img, 0, 0, img.width, img.height, matrix, true)
        img.recycle()
        return rotatedImg
    }


    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.delivered_btn -> {
                if (isDelivered) {
                    markDelivered(token, order?.orderId!!)
                } else {
                    showSnack(R.string.upload_image_first)
                }
            }
            R.id.help_number -> {
                val num = this.resources.getString(R.string.help_number)
                Intent(Intent.ACTION_DIAL).apply {
                    data = Uri.parse("tel:$num")
                }.also { startActivity(it) }
            }
        }
    }

    override fun onStart() {
        supportActionBar?.title = "#${order?.orderId}"
        //binding.deliveredBtn.isEnabled=imageUploaded
        super.onStart()
    }

    override fun findContentView(): Int {
        return R.layout.activity_receipt
    }

    override fun bindViewWithViewBinding(view: View) {
        binding = ActivityReceiptBinding.bind(view)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }

    private fun getOrderDetail(token: String, orderId: String) {

        val orderDetail = apiService.getOrderDetail("Bearer $token", orderId)
        orderDetail.enqueue(object : Callback<OrderDetail> {
            override fun onResponse(call: Call<OrderDetail>, response: Response<OrderDetail>) {
                if (response.isSuccessful) {
                    if (response.body()?.status!!) {
                        renderDetail(response.body()?.result?.orderInfo!!)
                        if (response.body()?.result?.detail?.isEmpty()!!) {
                            binding.noData.visibility = View.VISIBLE
                        } else {
                            binding.noData.visibility = View.GONE
                            renderSubOrders(response.body()?.result?.detail!!)
                        }
                    }
                    Log.d("data getting", response.body()?.result?.orderInfo?.shippingCity!!)
                } else {
                    shared.edit().clear().commit()
                    Intent(
                        this@ReceiptActivity,
                        LoginActivity::class.java
                    ).also {
                        startActivity(it)
                        finish()
                    }
                }
            }

            override fun onFailure(call: Call<OrderDetail>, t: Throwable) {
                Log.d("data getting", "failed")
            }

        })
    }

  //  private fun renderDetail(orderInfo: OrderDetail.Result.OrderInfo) {
    private fun renderDetail(orderInfo: OrderInfo) {
        binding.recName.text = orderInfo.shippingFirstname
        binding.delCity.text = orderInfo.shippingCity
        binding.recNum.text = orderInfo.shippingTelephone
        binding.altNum.text =
            if (orderInfo.shippingAlternateTelephone?.lowercase() == ("null")) "" else orderInfo.shippingAlternateTelephone
        binding.recAddress.text = orderInfo.shippingAddress1
        binding.addressType.text = orderInfo.shippingAddressType
    }

    private fun markDelivered(token: String, orderId: String) {
        try {
            dialog.show()
            val markDeliver = apiService.markDelevered("Bearer $token", orderId)

            markDeliver.enqueue(object : Callback<MessageDetail> {
                override fun onResponse(
                    call: Call<MessageDetail>,
                    response: Response<MessageDetail>
                ) {
                    if (response.isSuccessful) {
                        isDelivered = false

                        Log.d("Order delivered", "Order delivered")
                        showSnack(R.string.order_delivered)
                    } else {
                        isDelivered = true
                    }
                    binding.deliveredBtn.isEnabled = isDelivered
                    if (dialog.isShowing)
                        dialog.dismiss()
                }

                override fun onFailure(call: Call<MessageDetail>, t: Throwable) {
                    Log.d("Failed", "Something went wrong")
                    if (dialog.isShowing)
                        dialog.dismiss()
                }

            })
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    private fun uploadImage(
        token: String,
        orderId: String,
        imageUrl: File
    ) {

        try {
            dialog.show()
            Log.d("uploading", "uploading image started ${imageUrl.name.length}")
            val builder = MultipartBody.Builder()
            builder.setType(MultipartBody.FORM)
            builder.addFormDataPart("sub_order_id", orderId)
            builder.addFormDataPart(
                "images",
                imageUrl.name,
                RequestBody.create(MediaType.parse("multipart/form-data"), imageUrl)
            )
            val requestBody = builder.build()
            val upload = apiService.uploadImage("Bearer $token", requestBody)
            upload.enqueue(object : Callback<MessageDetail> {
                override fun onResponse(
                    call: Call<MessageDetail>,
                    response: Response<MessageDetail>
                ) {
                    if (response.isSuccessful) {
                        isDelivered = true
                        showSnack(R.string.upload_image_success)
                        subOrder?.upImage = response.body()!!.result.vendorImage!!

                        // subOrder?.upImage = pictureFilePath

                        binding.suborders.adapter?.notifyDataSetChanged()

                    } else {
                        isDelivered = false
                        showSnack(R.string.upload_image_failed)
                        Log.d("Failed", "Image not uploaded error")
                    }
                    if (dialog.isShowing)
                        dialog.dismiss()
                }

                override fun onFailure(call: Call<MessageDetail>, t: Throwable) {
                    Log.d("OnFailure", "Image not uploaded $call,$t")
                    showSnack(R.string.upload_image_failed)
                    if (dialog.isShowing)
                        dialog.dismiss()
                }

            })
        } catch (e: Exception) {
            e.stackTrace
            if (dialog.isShowing)
                dialog.dismiss()
            Log.d("Exception", "Image upload failed" + e.printStackTrace())
           // Log.d("Exception", "Image Upload issue $e")
        }

    }

    private fun showSnack(message: Int) {
        Snackbar.make(
            findViewById(R.id.context_view),
            message,
            Snackbar.LENGTH_LONG
        ).apply {
            setActionTextColor(
                Color.parseColor("#FFFFFF")
            )
        }
            .setAction("Ok", View.OnClickListener { // Request permission

            })
            .show()
    }
    private fun renderSubOrders(orders: ArrayList<Detail>) {
        // this creates a vertical layout Manager
        binding.suborders.layoutManager = LinearLayoutManager(this@ReceiptActivity)
        // This will pass the ArrayList to our Adapter
        val adapter = SubOrderAdapter(orders, this@ReceiptActivity, this)
        adapter.setHasStableIds(true)
        // Setting the Adapter with the recyclerview
        binding.suborders.adapter = adapter
    }
    @RequiresApi(Build.VERSION_CODES.R)
    override fun onItemClick(order: Detail, uImageView: ImageView) {
        Log.d("Suborder", order.subOrderId!!)
        subOrder = order
        imageView = uImageView
        checkPermissions(Manifest.permission.CAMERA, MY_PERMISSIONS_REQUEST_CAMERA)
    }
    private fun setPic() {
        // Get the dimensions of the View
        val targetW: Int = imageView!!.width
        val targetH: Int = imageView!!.height

        val bmOptions = BitmapFactory.Options().apply {
            // Get the dimensions of the bitmap
            inJustDecodeBounds = true

            BitmapFactory.decodeFile(currentPhotoPath, this)

            val photoW: Int = outWidth
            val photoH: Int = outHeight

            // Determine how much to scale down the image
            val scaleFactor: Int = Math.max(2, Math.min(photoW / targetW, photoH / targetH))

            // Decode the image file into a Bitmap sized to fill the View
            inJustDecodeBounds = false
            inSampleSize = scaleFactor
            inPurgeable = true
        }
        BitmapFactory.decodeFile(currentPhotoPath, bmOptions)?.also { bitmap ->
            imageView?.setImageBitmap(bitmap)
        }
    }

    override fun onPause() {
        Log.d("pause", "Into on pause")
        super.onPause()
    }

    override fun onRestart() {
        Log.d("restart", "into restart")
        super.onRestart()
    }

    override fun onResume() {
        Log.d("resume", "in resume")
        super.onResume()
    }


}