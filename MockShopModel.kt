package com.example.myassigement_async.MockShop_Module

import android.provider.ContactsContract
import com.example.myassigement_async.LocalProduct_Module.Records
import com.google.gson.annotations.SerializedName


data class MockShopModel (
    @SerializedName("success") var success : Boolean,
    @SerializedName("records") var records : List<Records>
)
data class Records(
    @SerializedName("id") var id : String,
    @SerializedName("title") var title : String,
    @SerializedName("description") var description : String,
    @SerializedName("featuredImage") var featuredImage : FeaturedImage,
    @SerializedName("variants") var variants : Variants,
    @SerializedName("amount") var amount : String,
    @SerializedName("price") var price : Price,
    @SerializedName("image") var image : Image,


)

data class FeaturedImage (

    @SerializedName("id") var id : String,
    @SerializedName("url") var url : String

)
data class Image (

    @SerializedName("url") var url : String

)
data class Price (

    @SerializedName("amount") var amount : String,
    @SerializedName("currencyCode") var currencyCode : String

)
data class Node (

    @SerializedName("id") var id : String,
    @SerializedName("title") var title : String,
    @SerializedName("image") var image : Image,
    @SerializedName("price") var price : Price

)
data class Edges (

    @SerializedName("cursor") var cursor : String,
    @SerializedName("node") var node : Node

)
data class Variants (

    @SerializedName("edges") var edges : List<Edges>

)
data class Product (

    @SerializedName("id") var id : String,
    @SerializedName("title") var title : String,
    @SerializedName("description") var description : String,
    @SerializedName("featuredImage") var featuredImage : FeaturedImage,
    @SerializedName("variants") var variants : Variants

)
data class Data (

    @SerializedName("product") var product : Product

)