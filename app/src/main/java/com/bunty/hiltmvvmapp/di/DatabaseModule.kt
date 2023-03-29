package com.bunty.daggermvvmapp.di

import android.content.Context
import androidx.room.Room
import com.bunty.daggermvvmapp.db.ProductDb
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideProductDb(@ApplicationContext context: Context): ProductDb {
        return Room.databaseBuilder(context, ProductDb::class.java, "FakerDb").build()
    }

}