package com.example.dependencyinjection.data.source.remote.service

import com.example.dependencyinjection.data.source.remote.response.RootResponse
import retrofit2.http.GET

interface ApiService {

    @GET("api/v1/json/1/all_sports.php")
    suspend fun getAllSport() : RootResponse
}