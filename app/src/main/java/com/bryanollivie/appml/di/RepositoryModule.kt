package com.bryanollivie.appml.di

import com.bryanollivie.appml.data.local.LocalProdRepository
import com.bryanollivie.appml.data.local.ProductDao
import com.bryanollivie.appml.data.remote.ProdApiService
import com.bryanollivie.appml.data.remote.RemoteProdRepository
import com.bryanollivie.appml.domain.repository.ProdRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    //Local
    @Provides
    fun provideLocalProductRepository(prodDao: ProductDao): LocalProdRepository {
        return LocalProdRepository(prodDao)
    }

    //Remote
    @Provides
    fun provideRemoteProductRepository(productService: ProdApiService): RemoteProdRepository {
        return RemoteProdRepository(productService)
    }

    @Provides
    fun provideProductRepository(
        //localRepo: LocalProdRepository,
        remoteRepo: RemoteProdRepository
    ): ProdRepository {
        //return ProdRepository(localRepo, remoteRepo)
        return ProdRepository(remoteRepo)
    }
}
