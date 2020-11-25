package com.example.dependencyinjection.di

import com.example.dependencyinjection.data.SportRepository
import com.example.dependencyinjection.data.source.remote.RemoteDataSource
import com.example.dependencyinjection.data.source.remote.service.ApiConfig
import com.example.dependencyinjection.domain.usecase.SportInteractor
import com.example.dependencyinjection.domain.usecase.SportUseCase

object Injection  {
    fun provideRepository() : SportRepository {
        val remote = RemoteDataSource.getInstance(ApiConfig.provideApiService())
        return SportRepository.getInstance(remote)
    }

    fun provideUseCase() : SportUseCase {
        val repository = provideRepository()
        return SportInteractor(repository)
    }

}