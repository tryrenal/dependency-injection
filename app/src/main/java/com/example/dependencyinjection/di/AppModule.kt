package com.example.dependencyinjection.di

import com.example.dependencyinjection.domain.usecase.SportInteractor
import com.example.dependencyinjection.domain.usecase.SportUseCase
import com.example.dependencyinjection.ui.MainViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    factory<SportUseCase> { SportInteractor(get()) }
}

val viewModelModule = module {
    viewModel { MainViewModel(get()) }
}