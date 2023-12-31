package com.bryanollivie.appml.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.bryanollivie.appml.data.local.AppMLDatabase
import com.bryanollivie.appml.data.local.ProductDao
import com.bryanollivie.appml.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.internal.managers.ApplicationComponentManager
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


/*
@Module
@InstallIn(SingletonComponent::class)*/

@Module
@InstallIn(SingletonComponent::class)
object LocalModule {

    @Provides
    @Singleton
    fun provideLocalDatabase(@ApplicationContext appContext: Context): AppMLDatabase{
    //fun provideLocalDatabase(app: Application): AppDatabase{

        /*val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "nome-do-banco-de-dados"
        ).build()*/

        return Room.databaseBuilder(appContext, AppMLDatabase::class.java, Constants.LOCAL_DATABASE_NAME)
            .fallbackToDestructiveMigration()
            .build()
    }


    @Provides
    fun provideProductDao(appDatabase: AppMLDatabase): ProductDao =
        appDatabase.productDao()
}