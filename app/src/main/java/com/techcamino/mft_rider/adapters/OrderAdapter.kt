package com.techcamino.mft_rider.adapters

import android.annotation.SuppressLint
import android.content.ContentValues.TAG
import android.content.Context
import android.graphics.Color
import android.text.Spannable
import android.text.SpannableString
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.techcamino.mft_rider.R
import com.techcamino.mft_rider.models.orders.Order

class OrderAdapter(
    private val mList: List<Order.Result.Orders>,
    private val context: Context,
    val itemClickListener: OnItemClickListener
) : RecyclerView.Adapter<OrderAdapter.ViewHolder>() {


    interface OnItemClickListener {
        fun onItemClick(order: Order.Result.Orders)
        fun changeState(order: Order.Result.Orders, status: Boolean)
        fun viewMap(order: Order.Result.Orders)
    }

    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context).inflate(R.layout.order_view_design, parent, false)

        return ViewHolder(view)
    }

    // binds the list items to a view
    @SuppressLint("ResourceAsColor")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val order = mList[position]


        // sets the image to the imageview from our itemHolder class
        //holder.imageView.setImageResource(order.images[0])
        Glide.with(context)
            .load(order.images[0])
            .override(600, 600)
            .fitCenter()
            .centerCrop()
            .error(R.drawable.logo)
            .into(holder.imageView);
        // sets the text to the textview from our itemHolder class
        holder.delAddress.text = order.address
        holder.orderId.text = "#${order.orderId}"
        holder.tv_product_count.text=order.subOrder

       /* var standard_delivery=order.shippingmethod
        val spannableString = SpannableString(standard_delivery)
        val foregroundColorSpan =ForegroundColorSpan(Color.GRAY)
        spannableString.setSpan(foregroundColorSpan,0,8,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)

        holder.delMethod.text=spannableString*/

      if(order.shippingmethod=="Standard Delivery"){
          holder.delMethod.text=order.shippingmethod
          holder.delMethod.setTextColor(R.color.grey)
      }else if(order.shippingmethod=="Fix Time Delivery"){
          holder.delMethod.text=order.shippingmethod
          holder.delMethod.setTextColor(R.color.orange)
      }else{
          holder.delMethod.text=order.shippingmethod
          holder.delMethod.setTextColor(R.color.red)
      }


        holder.delMethod.text=order.shippingmethod

        Log.d(TAG, "onBindViewHolder: ${order.shippingmethod}")

        var fixedTime = order.shippingtimeslot
        holder.delTime.text=fixedTime

       /* if(fixedTime=="Midnight"){
            holder.delTime.text=order.shippingtimeslot
            holder.delTime.setTextColor(context.getColor(R.color.red))
        }else{
            holder.delTime.text = order.shippingtimeslot
        }*/

      //  holder.delTime.text = order.shippingtimeslot
        Log.d(TAG, "onBindViewHolder: ${order.shippingtimeslot}")


        when (order.riderStatus?.lowercase()) {
            "accepted_orders" -> {
                holder.viewMap.visibility = View.VISIBLE
                holder.decline.visibility = View.GONE
             //   holder.acptText.text = context.resources.getString(R.string.accepted)
                holder.acptText.text=context.resources.getString(R.string.pickedup)
                holder.acptText.setBackgroundColor(context.getColor(R.color.green))

            }
            "declined_orders" -> {
                holder.decText.text = context.resources.getString(R.string.declined)
                holder.decText.visibility=View.GONE

            }
            "delivered_orders"->{
                holder.actionRow.visibility=View.VISIBLE
                holder.accept.visibility=View.GONE
                holder.decText.text=context.getText(R.string.delivered)
            }
            else -> {
                holder.viewMap.visibility = View.GONE
                holder.decline.visibility = View.VISIBLE
            }

        }
        holder.bind(order, itemClickListener)

    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return mList.size
    }

    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {

        val imageView: ImageView = itemView.findViewById(R.id.imageview)
        val delAddress: TextView = itemView.findViewById(R.id.del_address)
        val orderId: TextView = itemView.findViewById(R.id.order_id)
        val decText: TextView = itemView.findViewById(R.id.dec_text)
        val delTime: TextView = itemView.findViewById(R.id.del_time)
        val delMethod: TextView = itemView.findViewById(R.id.del_method)
        val acptText: TextView = itemView.findViewById(R.id.acpt_text)
        val decline: CardView = itemView.findViewById(R.id.decline_btn)
        val accept: CardView = itemView.findViewById(R.id.accept_btn)
        val viewMap: CardView = itemView.findViewById(R.id.view_map)
        val tv_product_count : TextView= itemView.findViewById(R.id.tv_product_count)
        val actionRow:LinearLayout = itemView.findViewById(R.id.action_row)

        fun bind(item: Order.Result.Orders, listener: OnItemClickListener) {
            itemView.setOnClickListener { listener.onItemClick(item) }
            //if (item.riderStatus?.lowercase() != "declined")
            decline.setOnClickListener {
                listener.changeState(
                    item,
                    false
                )
            }
            //if (item.riderStatus?.lowercase() != "accepted")
            accept.setOnClickListener {
                listener.changeState(
                    item,
                    true
                )
            }
            viewMap.setOnClickListener { listener.viewMap(item) }
        }
    }
}