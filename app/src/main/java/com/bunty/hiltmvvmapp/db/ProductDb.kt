package com.bunty.daggermvvmapp.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.bunty.daggermvvmapp.models.Product

@Database(entities = [Product::class], version = 1)
abstract class ProductDb : RoomDatabase() {
    abstract fun getProductDao(): ProductsDao
}