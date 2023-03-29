package com.bunty.daggermvvmapp.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.bunty.daggermvvmapp.db.ProductDb
import com.bunty.daggermvvmapp.models.Product
import com.bunty.daggermvvmapp.retrofit.ApiInterface
import javax.inject.Inject

class ProductRepository @Inject constructor(
    private val apiInterface: ApiInterface,
    private val productDb: ProductDb
) {

    private val _product = MutableLiveData<List<Product>>()
    val products: LiveData<List<Product>>
        get() = _product

    suspend fun getProducts() {
        val result = apiInterface.getProducts()
        if (result.isSuccessful && result.body() != null) {
            productDb.getProductDao().addProduct(result.body()!!)
            _product.postValue(result.body())
        }
    }
}