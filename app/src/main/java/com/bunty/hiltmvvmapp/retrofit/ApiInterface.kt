package com.bunty.daggermvvmapp.retrofit

import com.bunty.daggermvvmapp.models.Product
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {

    @GET("products")
    suspend fun getProducts(): Response<List<Product>>
}