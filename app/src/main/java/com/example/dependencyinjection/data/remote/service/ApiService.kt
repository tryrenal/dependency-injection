package com.example.dependencyinjection.data.remote.service

import com.example.dependencyinjection.data.remote.response.RootResponse
import retrofit2.http.GET

interface ApiService {

    @GET("api/v1/json/1/all_sports.php")
    fun getAllSport() : RootResponse
}