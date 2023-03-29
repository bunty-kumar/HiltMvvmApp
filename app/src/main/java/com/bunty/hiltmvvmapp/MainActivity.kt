package com.bunty.hiltmvvmapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.bunty.daggermvvmapp.viewmodel.ProductViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var productViewModel: ProductViewModel

    private val tvProduct: TextView
        get() = findViewById(R.id.tvProduct)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        productViewModel = ViewModelProvider(this)[ProductViewModel::class.java]

        productViewModel.productLiveData.observe(this) {
            tvProduct.text = it.joinToString { x -> x.title + "\n\n" }
        }

    }

}