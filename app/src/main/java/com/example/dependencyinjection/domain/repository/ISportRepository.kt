package com.example.dependencyinjection.domain.repository

import com.example.dependencyinjection.domain.model.Sport
import com.example.dependencyinjection.vo.Resource
import kotlinx.coroutines.flow.Flow

interface ISportRepository {
    fun getSports() : Flow<Resource<List<Sport>>>
}