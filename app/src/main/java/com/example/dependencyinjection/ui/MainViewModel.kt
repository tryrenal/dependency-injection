package com.example.dependencyinjection.ui

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.dependencyinjection.domain.usecase.SportUseCase

class MainViewModel @ViewModelInject constructor(useCase: SportUseCase) : ViewModel() {

    val sports = useCase.getSports().asLiveData()

}