package com.bryanollivie.appml.data.local

import com.bryanollivie.appml.data.local.dao.ProductDao
import com.bryanollivie.appml.data.local.entity.ResultsItemEntity
import javax.inject.Inject

class LocalRepository @Inject constructor(private val productDao: ProductDao) {

    //Products
    fun getAllProducts(): List<ResultsItemEntity> {
        return productDao.getAll()
    }

    fun getProductsByTitle(title: String): ResultsItemEntity {
        return productDao.getByTitle(title)
    }

    fun getAllProductsBySearch(query: String): List<ResultsItemEntity> {
        return productDao.getAllBySearch(query)
    }

    fun saveAllProducts(products: List<ResultsItemEntity>){
        return productDao.insertAll(products)
    }

    fun saveProducts(products: List<ResultsItemEntity>){
        return productDao.insertAll(products)
    }

    fun deleteAllProducts(){
        return productDao.deleteAll()
    }


}

