package com.bryanollivie.appml.data.remote

import retrofit2.http.GET

import retrofit2.http.Query

interface ProdApiService {

    @GET("sites/MLA/search")
    suspend fun getSearchProd(@Query("q") prod: String): Response
    //suspend fun getSearchProd(@Query("q") product: String): List<ResultsItem>


}