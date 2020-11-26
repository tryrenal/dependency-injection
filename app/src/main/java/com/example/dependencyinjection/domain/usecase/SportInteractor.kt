package com.example.dependencyinjection.domain.usecase

import com.example.dependencyinjection.domain.model.Sport
import com.example.dependencyinjection.domain.repository.ISportRepository
import com.example.dependencyinjection.vo.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class SportInteractor @Inject constructor(private val repository: ISportRepository) : SportUseCase  {
    override fun getSports(): Flow<Resource<List<Sport>>> = repository.getSports()
}