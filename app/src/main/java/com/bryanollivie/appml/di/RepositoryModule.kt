package com.bryanollivie.appml.di

import com.bryanollivie.appml.data.local.LocalRepository
import com.bryanollivie.appml.data.local.dao.ProductDao
import com.bryanollivie.appml.data.remote.ProdApiService
import com.bryanollivie.appml.data.remote.RemoteProdRepository
import com.bryanollivie.appml.domain.repository.AppRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    //Local
    @Provides
    fun provideLocalRepository(prodDao: ProductDao): LocalRepository {
        return LocalRepository(prodDao)
    }

    //Remote
    @Provides
    fun provideRemoteProductRepository(productService: ProdApiService): RemoteProdRepository {
        return RemoteProdRepository(productService)
    }

    @Provides
    fun provideProductRepository(
        localRepo: LocalRepository,
        remoteRepo: RemoteProdRepository
    ): AppRepository {
        return AppRepository(localRepo, remoteRepo)
    }
}
