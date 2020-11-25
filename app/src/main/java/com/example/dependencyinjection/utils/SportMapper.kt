package com.example.dependencyinjection.utils

import com.example.dependencyinjection.data.source.remote.response.SportResponse
import com.example.dependencyinjection.domain.model.Sport

object SportMapper {

    fun responseToModel(data: List<SportResponse>) : List<Sport> {
        return data.map {
            Sport(
                id = it.idSport,
                name = it.strSport,
                format = it.strFormat,
                sportThumb = it.strSportThumb,
                sportThumbGreen = it.strSportThumbGreen,
                sportDesc = it.strSportDesc
            )
        }
    }
}