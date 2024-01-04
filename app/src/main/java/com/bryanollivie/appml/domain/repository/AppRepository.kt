package com.bryanollivie.appml.domain.repository

import com.bryanollivie.appml.data.Converters
import com.bryanollivie.appml.data.local.LocalRepository
import com.bryanollivie.appml.data.local.entity.ResultsItemEntity
import com.bryanollivie.appml.data.remote.RemoteProdRepository
import com.bryanollivie.appml.data.remote.ResponseDto
import javax.inject.Inject

class AppRepository @Inject constructor(
    private val localRepository: LocalRepository,
    private val remoteRepository: RemoteProdRepository
) {
    //sem cache local
    suspend fun getSearchProd(prod:String): ResponseDto? {
        val resultSearch = remoteRepository.getSearchProd(prod)

        //saveAllProducts(Converters.productDtoListToEntityList(resultSearch.results))

        return resultSearch
    }

    // User
    /*fun getLocalAllUsers(): List<User>? {
        return localRepository.getAllUsers()
    }

    fun saveLocalUsers(users:List<User>) {
        return localRepository.saveUsers(users)
    }*/

    // Local Products
    fun getAllProductsBySearch(query: String): List<ResultsItemEntity> {
        return localRepository.getAllProductsBySearch(query)
    }

    fun saveAllProducts(products: List<ResultsItemEntity>){
        return localRepository.saveAllProducts(products)
    }

    fun getAllProducts(): List<ResultsItemEntity> {
        return localRepository.getAllProducts()
    }

    fun deleteAllProducts(){
        return localRepository.deleteAllProducts()
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
