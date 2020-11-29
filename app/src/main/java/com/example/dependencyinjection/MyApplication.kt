package com.example.dependencyinjection

import android.app.Application
import com.example.dependencyinjection.data.di.networkModule
import com.example.dependencyinjection.data.di.repositoryModule
import com.example.dependencyinjection.di.useCaseModule
import com.example.dependencyinjection.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@MyApplication)
            modules(
                listOf(
                    networkModule,
                    repositoryModule,
                    useCaseModule,
                    viewModelModule
                )
            )
        }
    }
}