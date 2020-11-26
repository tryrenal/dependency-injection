package com.example.dependencyinjection.data.di

import android.content.Context
import com.example.dependencyinjection.domain.repository.ISportRepository
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [RepositoryModule::class]
)
interface DataComponent {
    @Component.Factory
    interface Factory{
        fun create(@BindsInstance context: Context) : DataComponent
    }

    fun provideRepository() : ISportRepository
}