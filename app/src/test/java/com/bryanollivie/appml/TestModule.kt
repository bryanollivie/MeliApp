package com.bryanollivie.appml

import com.bryanollivie.appml.data.local.LocalRepository
import com.bryanollivie.appml.di.LocalModule
import com.bryanollivie.appml.di.NetworkModule
import com.bryanollivie.appml.di.RepositoryModule
import com.bryanollivie.appml.domain.repository.AppRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.mockito.Mockito

@Module
@InstallIn(SingletonComponent::class)
object TestModule {
/*
    @Provides
    fun provideFakeRemoteDataSource(): FakeNetworkModule{
        return MockRemoteDataSource()
    }*/

    /*@Provides
    fun provideLocalDataSource(): LocalRepository = Mockito.mock(LocalRepository::class.java)*/
    /*
        @Provides
        fun provideFakeLocalDataSource(): FakeLocalDataSource {
            return MockLocalDataSource()
        }

    @Provides
    fun provideLocalDataSource(): LocalRepository(Mockito.mock(Produ::class.java)) = Mockito.mock(LocalRepository::class.java)
    */

/*
    @Provides
    fun provideRepository(
        remoteDataSource: FakeRemoteDataSource,
        localDataSource: FakeLocalDataSource
    ): MyRepository {
        return MyRepositoryImpl(remoteDataSource, localDataSource)
    }*/

    // Outros mocks ou objetos falsos conforme necessário...
}

