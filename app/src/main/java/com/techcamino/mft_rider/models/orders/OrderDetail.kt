package com.techcamino.mft_rider.models.orders

import com.google.gson.annotations.SerializedName

/*data class OrderDetail(
    @SerializedName("status") var status: Boolean? = null,
    @SerializedName("message") var message: String? = null,
    @SerializedName("result") var result: Result? = Result()
) {
    data class Result(

        @SerializedName("order_info") var orderInfo: OrderInfo? = OrderInfo(),
        @SerializedName("detail") var detail: ArrayList<OrderInfo.Detail> = arrayListOf()

    ) {
        data class OrderInfo(

            @SerializedName("order_id") var orderId: String? = null,
            @SerializedName("shipping_firstname") var shippingFirstname: String? = null,
            @SerializedName("shipping_city") var shippingCity: String? = null,
            @SerializedName("shipping_telephone") var shippingTelephone: String? = null,
            @SerializedName("shipping_alternate_telephone") var shippingAlternateTelephone: String? = null,
            @SerializedName("shipping_address_1") var shippingAddress1: String? = null,
            @SerializedName("shipping_postcode") var shippingPostcode: String? = null,
            @SerializedName("shipping_address_type") var shippingAddressType: String? = null

        ) {
            data class Detail(

                @SerializedName("product_id") var productId: String? = null,
                @SerializedName("sub_order_id") var subOrderId: String,
                @SerializedName("image") var image: String? = null,
                var upImage: String? = null,
                @SerializedName("vendorProImg") var vendorProImg: String? = null

            ) {

            }
        }
    }

}*/


data class OrderDetail(
    @SerializedName("status") var status: Boolean,
    @SerializedName("message") var message: String,
    @SerializedName("result") var result: Result
)
data class Result(

    @SerializedName("order_info") var orderInfo: OrderInfo,
    @SerializedName("detail") var detail: ArrayList<Detail>

)



data class OrderInfo(

    @SerializedName("order_id") var orderId: String,
    @SerializedName("shipping_firstname") var shippingFirstname: String,
    @SerializedName("shipping_city") var shippingCity: String,
    @SerializedName("shipping_telephone") var shippingTelephone: String,
    @SerializedName("shipping_alternate_telephone") var shippingAlternateTelephone: String,
    @SerializedName("shipping_address_1") var shippingAddress1: String,
    @SerializedName("shipping_postcode") var shippingPostcode: String,
    @SerializedName("shipping_address_type") var shippingAddressType: String

)

data class Detail(

    @SerializedName("product_id") var productId: String,
    @SerializedName("sub_order_id") var subOrderId: String,
    @SerializedName("image") var image: String,
    var upImage: String,
    @SerializedName("vendorProImg") var vendorProImg: String

)


