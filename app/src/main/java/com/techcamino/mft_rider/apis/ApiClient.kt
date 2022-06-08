package com.techcamino.mft_rider.apis


import com.mikhaellopez.circularimageview.BuildConfig

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


object ApiClient {

   // val baseUrl = "https://partner.myflowertree.com/"//""https://quotable.io/"

    val baseUrl = "https://partner.myflowertree.com"//""https://quotable.io/"

  //  val baseUrl = "http://15.207.192.120" //""https://quotable.io/"

//   val baseUrl = "http://15.207.232.245/vendors/" //""https://quotable.io/" // http://15.207.232.245/vendors/riderapp/api/loginRider


    val apiInterface: ApiInterface

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(getHttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        apiInterface = retrofit.create(ApiInterface::class.java)
    }

    private fun getHttpClient():OkHttpClient{
        if(BuildConfig.DEBUG){
           // disable logger in production
        }
    val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        val httpClient = OkHttpClient.Builder()

        httpClient.connectTimeout(5, TimeUnit.MINUTES) // connect timeout
            .connectTimeout(5,TimeUnit.MINUTES)
            .writeTimeout(5, TimeUnit.MINUTES) // write timeout
            .readTimeout(5, TimeUnit.MINUTES) // read timeout
            .build()
      //  okHttpClient = builder.build();

        httpClient.addInterceptor(logging)
        return httpClient.build()
    }
}