package com.bryanollivie.appml.di

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object LocalModule {
    // Aqui você configuraria e proveria sua base de dados, DAOs, etc.
}