package com.bryanollivie.appml.di

import android.content.Context
import androidx.room.Room
import com.bryanollivie.appml.data.local.AppDatabase
import com.bryanollivie.appml.data.local.dao.ProductDao
import com.bryanollivie.appml.data.local.dao.UserDao
import com.bryanollivie.appml.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LocalModule {

    @Provides
    @Singleton
    fun provideLocalDatabase(@ApplicationContext appContext: Context): AppDatabase{

        return Room.databaseBuilder(appContext, AppDatabase::class.java, Constants.LOCAL_DATABASE_NAME)
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    fun provideProductDao(appDatabase: AppDatabase): ProductDao =
        appDatabase.productDao()

    @Provides
    fun provideUserDao(appDatabase: AppDatabase): UserDao =
        appDatabase.userDao()


}
