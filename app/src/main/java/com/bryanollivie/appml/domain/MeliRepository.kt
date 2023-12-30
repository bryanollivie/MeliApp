package com.bryanollivie.appml.domain

import com.bryanollivie.appml.data.remote.Response

interface MeliRepository {

    suspend fun getSearchProd(prod:String): Response

}