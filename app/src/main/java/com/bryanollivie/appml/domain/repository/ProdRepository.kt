package com.bryanollivie.appml.domain.repository

import com.bryanollivie.appml.data.local.LocalProdRepository
import com.bryanollivie.appml.data.local.ResponseEntity
import com.bryanollivie.appml.data.remote.RemoteProdRepository
import com.bryanollivie.appml.data.remote.ResponseDto
import javax.inject.Inject

class ProdRepository @Inject constructor(/*
    private val localRepository: LocalProdRepository,*/
    private val remoteRepository: RemoteProdRepository
) {
    //sem cache local
    suspend fun getSearchProd(prod:String): ResponseDto? {
        return remoteRepository.getSearchProd(prod)
    }

    //com cache local
    /*suspend fun getAllBySearchProductsWithCache(search: String): ResponseEntity {

        // Tentar obter do cache local primeiro
        val localData = localRepository?.getAllBySearchProducts(search)
        if (localData != null) {
            return localData
        }

        // Se não estiver disponível localmente, buscar da API
        val remoteData = remoteRepository.getAllBySearchProducts(search)

        // Salvar no banco de dados local para cache
        localRepository?.saveBySearchProducts(ResponseEntity(remoteData.query))

        return ResponseEntity(remoteData.query)
    }*/


}
