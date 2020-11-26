package com.example.dependencyinjection.di

import com.example.dependencyinjection.domain.usecase.SportInteractor
import com.example.dependencyinjection.domain.usecase.SportUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
abstract class AppModule {
    @Binds
    abstract fun provideSportUseCase(sportInteractor: SportInteractor): SportUseCase
}