package com.bunty.daggermvvmapp.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.bunty.daggermvvmapp.models.Product

@Dao
interface ProductsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addProduct(products: List<Product>)

    @Query("SELECT * FROM Product")
    suspend fun getProduct(): List<Product>
}