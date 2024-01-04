package com.bryanollivie.appml.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.bryanollivie.appml.data.local.entity.ResponseEntity
import com.bryanollivie.appml.data.local.entity.ResultsItemEntity
import com.bryanollivie.appml.data.local.entity.User

@Dao
interface ProductDao {

    @Query("SELECT * FROM 'products'")
    fun getAll(): List<ResultsItemEntity>

    @Query("SELECT * FROM products WHERE product_id IN (:ids)")
    fun getAllByIds(ids: IntArray): List<ResultsItemEntity>

    //@Query("SELECT * FROM products WHERE query_search LIKE :%query% ")
    @Query("SELECT * FROM products WHERE query_search LIKE :query")
    fun getAllBySearch(query: String): List<ResultsItemEntity>

    @Query("SELECT * FROM products WHERE title LIKE :title LIMIT 1")
    fun getByTitle(title: String): ResultsItemEntity

    @Insert
    fun insertAll(products: List<ResultsItemEntity>)

    @Delete
    fun delete(product: ResultsItemEntity)

    @Query("DELETE FROM products")
    fun deleteAll()

}
