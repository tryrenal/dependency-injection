package com.example.dependencyinjection

import android.app.Application
import com.example.dependencyinjection.data.di.DaggerDataComponent
import com.example.dependencyinjection.data.di.DataComponent
import com.example.dependencyinjection.di.AppComponent
import com.example.dependencyinjection.di.DaggerAppComponent

open class MyApplication : Application(){

    private val dataComponent:  DataComponent by lazy {
        DaggerDataComponent.factory().create(applicationContext)
    }

    val appComponent: AppComponent by lazy {
        DaggerAppComponent.factory().create(dataComponent)
    }
}