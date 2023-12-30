package com.bryanollivie.appml.data.remote

class RemoteProdRepository(private val prodService: ProdApiService) {

    suspend fun getSearchProd(prod: String): Response {
        return prodService.getSearchProd(prod)
    }

}