package com.example.dependencyinjection.data.remote

import com.example.dependencyinjection.data.remote.service.ApiService

class RemoteDataSource(
        private val apiService: ApiService
) {

}