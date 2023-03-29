package com.bunty.daggermvvmapp.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bunty.daggermvvmapp.models.Product
import com.bunty.daggermvvmapp.repository.ProductRepository
import com.bunty.daggermvvmapp.utils.Constants.TAG
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(
    private val productRepository: ProductRepository
) : ViewModel() {

    val productLiveData: LiveData<List<Product>>
        get() = productRepository.products

    init {
        viewModelScope.launch {
            productRepository.getProducts()
        }
    }
}
