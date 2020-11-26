package com.example.dependencyinjection.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.dependencyinjection.di.AppScope
import com.example.dependencyinjection.domain.usecase.SportUseCase
import com.example.dependencyinjection.ui.MainViewModel
import javax.inject.Inject

@AppScope
class ViewModelFactory @Inject constructor(private val useCase: SportUseCase) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(MainViewModel::class.java) -> {
                MainViewModel(useCase) as T
            }
            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }
    }
}