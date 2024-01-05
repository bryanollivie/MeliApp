package com.bryanollivie.appml.data.remote

import retrofit2.http.GET
import retrofit2.http.Query

interface ProdApiService {

    @GET("sites/MLA/search")
    suspend fun getSearchProd(@Query("q") prod: String): ResponseDto

    @GET("sites/MLA/search")
    suspend fun getAllBySearchProducts(@Query("q") search: String): ResponseDto

}