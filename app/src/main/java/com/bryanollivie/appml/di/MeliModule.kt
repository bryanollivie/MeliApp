package com.bryanollivie.appml.di

/*

@Module
@InstallIn(SingletonComponent::class)
object MeliModule {

    @Provides
    @Singleton
    fun provideMeliApi(): ApiService {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            //.addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideMeliRepository(api:ApiService):MeliRepository{
        return MeliRepositoryImpl(api=api)
    }
}*/
