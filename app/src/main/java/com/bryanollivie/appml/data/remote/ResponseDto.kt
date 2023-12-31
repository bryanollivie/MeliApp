package com.bryanollivie.appml.data.remote

data class ResponseDto(

    val results: List<ResultsItemDto?>? = null,
    val query: String? = null,
    val country_default_time_zone: String? = null
)