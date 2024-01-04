package com.bryanollivie.appml.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.bryanollivie.appml.data.local.AppDatabase
import com.bryanollivie.appml.data.local.ProductDao
import com.bryanollivie.appml.data.local.UserDao
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
    fun provideLocalDatabase(@ApplicationContext appContext: Context): AppDatabase{
        //fun provideLocalDatabase(app: Application): AppDatabase{


        /*val db = Room.databaseBuilder(
            appContext,
            AppDatabase::class.java, "nome-do-banco-de-dados"
        ).build()*/


        return Room.databaseBuilder(appContext, AppDatabase::class.java, Constants.LOCAL_DATABASE_NAME)
            .fallbackToDestructiveMigration()
            .build()
    }


    /*@Provides
    fun provideProductDao(appDatabase: AppDatabase): ProductDao =
        appDatabase.productDao()*/

    @Provides
    fun provideUserDao(appDatabase: AppDatabase): UserDao =
        appDatabase.userDao()


}
/*
db = Room.databaseBuilder(
Application.contex,
AppDatabase::class.java, "database_meli"
).build()
userDao = db.userDao()*/
