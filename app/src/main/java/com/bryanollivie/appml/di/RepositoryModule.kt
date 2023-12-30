package com.bryanollivie.appml.di

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
   /* @Provides
    fun provideLocalProductRepository(userDao: UserDao): LocalUserRepository {
        return LocalUserRepository(userDao)
    }*/

    //Remote
    @Provides
    fun provideRemoteProductRepository(productService: ProdApiService): RemoteProdRepository {
        return RemoteProdRepository(productService)
    }

    @Provides
    fun provideProductRepository(/*
        localRepo: LocalUserRepository,*/
        remoteRepo: RemoteProdRepository
    ): ProdRepository {
        return ProdRepository(/*localRepo,*/ remoteRepo)
    }
}

/*
@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    // Aqui você configuraria e proveria sua base de dados, DAOs, etc.
}


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    // Aqui você configuraria e proveria o Retrofit, o serviço de rede, etc.
}
*/
