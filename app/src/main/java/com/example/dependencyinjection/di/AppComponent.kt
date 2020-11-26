package com.example.dependencyinjection.di

import com.example.dependencyinjection.data.di.DataComponent
import com.example.dependencyinjection.ui.MainActivity
import dagger.Component

@AppScope
@Component(
    dependencies = [DataComponent::class],
    modules = [AppModule::class]
)
interface AppComponent {
    @Component.Factory
    interface Factory {
        fun create(dataComponent: DataComponent): AppComponent
    }

    fun inject(activity: MainActivity)
}