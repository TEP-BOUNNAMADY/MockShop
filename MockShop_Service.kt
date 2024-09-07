package com.example.myassigement_async.MockShop_Module

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

const val BASE_URL = "https://mock.shop"

interface MockShopService{
    @GET("products")
    suspend fun getMockShopProducts(): List<Records>

    companion object {
        var service : MockShopService? = null
        fun getInstance(): MockShopService {
            if(service == null){
                service = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(MockShopService::class.java)
            }
            return service!!
        }
    }
}