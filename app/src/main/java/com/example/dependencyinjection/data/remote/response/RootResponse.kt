package com.example.dependencyinjection.data.remote.response

import com.google.gson.annotations.SerializedName

data class RootResponse (
    @field:SerializedName("sports")
    val sports: List<SportResponse>
)