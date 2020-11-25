package com.example.dependencyinjection.domain.usecase

import com.example.dependencyinjection.domain.model.Sport
import com.example.dependencyinjection.vo.Resource
import kotlinx.coroutines.flow.Flow

interface SportUseCase {
    fun getSports() : Flow<Resource<List<Sport>>>
}