package com.bryanollivie.appml.data.remote

import com.bryanollivie.appml.data.remote.dto.ResponseDto

class RemoteProdRepository(private val prodService: ProdApiService) {

    suspend fun getSearchProd(prod: String): ResponseDto {
        return prodService.getSearchProd(prod)
    }

    suspend fun getAllBySearchProducts(search: String): ResponseDto {
        return prodService.getAllBySearchProducts(search)
    }

}