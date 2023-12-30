package com.bryanollivie.appml.domain.repository

import com.bryanollivie.appml.data.local.LocalProdRepository
import com.bryanollivie.appml.data.remote.RemoteProdRepository
import com.bryanollivie.appml.data.remote.Response

class ProdRepository(
    /*private val localRepository: LocalProdRepository? = null,*/
    private val remoteRepository: RemoteProdRepository
) {
    /*suspend fun getSearchProd(prod: String): prodEntity {
        // Tentar obter do cache local primeiro
        val localUser = localRepository.getUser(userId)
        if (localUser != null) {
            return localUser
        }

        // Se não estiver disponível localmente, buscar da API
        val remoteUser = remoteRepository.getUser(userId)
        // Salvar no banco de dados local para cache
        localRepository.saveUser(UserEntity(remoteUser.id, remoteUser.name, remoteUser.email))

        return UserEntity(remoteUser.id, remoteUser.name, remoteUser.email)
    }*/

    //sem cache local
    suspend fun getSearchProd(prod:String): Response {
        return remoteRepository.getSearchProd(prod)
    }
}
