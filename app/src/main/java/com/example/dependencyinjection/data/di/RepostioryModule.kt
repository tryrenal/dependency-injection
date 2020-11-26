package com.example.dependencyinjection.data.di

import com.example.dependencyinjection.data.SportRepository
import com.example.dependencyinjection.domain.repository.ISportRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@Module(includes = [NetworkModule::class])
@InstallIn(ApplicationComponent::class)
abstract class RepostioryModule {

    @Binds
    abstract fun provideRepository(repository: SportRepository) : ISportRepository
}