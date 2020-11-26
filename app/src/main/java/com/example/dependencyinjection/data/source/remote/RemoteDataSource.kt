package com.example.dependencyinjection.data.source.remote

import com.example.dependencyinjection.data.source.remote.response.SportResponse
import com.example.dependencyinjection.data.source.remote.service.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteDataSource @Inject constructor(
        private val apiService: ApiService
) {

    fun getSports() : Flow<ApiResponse<List<SportResponse>>> {
        return flow {
            try {
                val response = apiService.getAllSport()
                val data = response.sports
                if (data.isNotEmpty()){
                    emit(ApiResponse.Success(data))
                } else {
                    emit(ApiResponse.Empty)
                }
            }catch (e: Exception){
                emit(ApiResponse.Error(e.toString()))
            }
        }.flowOn(Dispatchers.IO)
    }
}