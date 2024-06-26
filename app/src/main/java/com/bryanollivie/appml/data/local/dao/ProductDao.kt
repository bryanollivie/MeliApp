package com.bryanollivie.appml.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.bryanollivie.appml.data.local.entity.ResponseEntity
import com.bryanollivie.appml.data.local.entity.ResultsItemEntity

@Dao
interface ProductDao {

    // Search
    @Query("SELECT * FROM result_search WHERE `query` LIKE :query")
    fun getSearchByQuery(query: String): ResponseEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertSearch(query: ResponseEntity)

    @Query("DELETE FROM result_search")
    fun deleteAllSearch()

    // Products
    @Query("SELECT * FROM 'products'")
    fun getAll(): List<ResultsItemEntity>

    @Query("SELECT * FROM products WHERE product_id IN (:ids)")
    fun getAllByIds(ids: IntArray): List<ResultsItemEntity>

    @Query("SELECT * FROM products WHERE query_search LIKE :query")
    fun getAllBySearch(query: String): List<ResultsItemEntity>

    @Query("SELECT * FROM products WHERE title LIKE :title LIMIT 1")
    fun getByTitle(title: String): ResultsItemEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(products: List<ResultsItemEntity>)

    @Delete
    fun delete(product: ResultsItemEntity)

    @Query("DELETE FROM products")
    fun deleteAll()

}
