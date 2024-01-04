package com.bryanollivie.appml.data.local

import com.bryanollivie.appml.data.local.entity.ResponseEntity
import com.bryanollivie.appml.data.local.entity.ResultsItemEntity

class LocalProdRepository(private val productDao: ProductDao) {

    fun searchById(productId: Int): ResultsItemEntity {
        return productDao.searchById(productId)
    }

    /* fun insertAll(vararg products: ResultsItemEntity): ResultsItemEntity {
        return productDao.insertAll(products)
    }*/

    fun searchAllProducts(): List<ResultsItemEntity> {
        return productDao.searchAllProducts()
    }



    fun getAllBySearchProducts(search: String?): ResponseEntity {
        return productDao.getAllBySearchProducts(search)
    }

    fun saveBySearchProducts(search: ResponseEntity?): ResponseEntity {
        return productDao.getAllBySearchProducts(search?.query)
    }

}

