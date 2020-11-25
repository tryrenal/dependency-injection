package com.example.dependencyinjection.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.dependencyinjection.domain.usecase.SportUseCase

class MainViewModel(useCase: SportUseCase) : ViewModel() {

    val sports = useCase.getSports().asLiveData()

}