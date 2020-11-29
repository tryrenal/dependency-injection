package com.example.dependencyinjection.data

import com.example.dependencyinjection.data.source.remote.ApiResponse
import com.example.dependencyinjection.data.source.remote.RemoteDataSource
import com.example.dependencyinjection.domain.model.Sport
import com.example.dependencyinjection.domain.repository.ISportRepository
import com.example.dependencyinjection.utils.SportMapper
import com.example.dependencyinjection.vo.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow

class SportRepository (
 private val remote: RemoteDataSource
) : ISportRepository {

    override fun getSports(): Flow<Resource<List<Sport>>> = flow {
        when(val response = remote.getSports().first()){
            is ApiResponse.Success -> {
                val sport = SportMapper.responseToModel(response.data)
                emit(Resource.Success(sport))
            }
            is ApiResponse.Error -> {
                emit(Resource.Error<List<Sport>>(message = response.error))
            }
            is ApiResponse.Empty -> {
                emit(Resource.Success(emptyList()))
            }
        }
    }
}