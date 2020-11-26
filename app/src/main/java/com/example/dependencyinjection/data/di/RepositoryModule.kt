package com.example.dependencyinjection.data.di

import com.example.dependencyinjection.data.SportRepository
import com.example.dependencyinjection.domain.repository.ISportRepository
import dagger.Binds
import dagger.Module

@Module(includes = [NetworkModule::class])
abstract class RepositoryModule {

    @Binds
    abstract fun provideRespository(repository: SportRepository) : ISportRepository
}