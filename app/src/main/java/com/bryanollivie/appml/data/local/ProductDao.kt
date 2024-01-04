package com.bryanollivie.appml.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.bryanollivie.appml.data.local.entity.ResponseEntity
import com.bryanollivie.appml.data.local.entity.ResultsItemEntity

@Dao
interface ProductDao {

    // Consultar todos os products por pesquisa especifica
    @Query("SELECT * FROM responseEntity   WHERE `query` LIKE :search")
    fun getAllBySearchProducts(search: String?): ResponseEntity



    // Consultar todos os products
    @Query("SELECT * FROM resultsItemEntity")
    fun searchAllProducts(): List<ResultsItemEntity>

    // Consultar um product por ID
    @Query("SELECT * FROM resultsItemEntity WHERE id = :id")
    fun searchById(id: Int): ResultsItemEntity

    // Consultar products por nome
    @Query("SELECT * FROM resultsItemEntity WHERE title LIKE :title")
    fun searchByTitle(title: String): List<ResultsItemEntity>

    // Inserir um único product
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun saveBySearchProducts(search: ResultsItemEntity)

    // Inserir múltiplos products
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun savetAll(vararg products: ResultsItemEntity)

    // Atualizar um product
    @Update
    fun updateProduct(product: ResultsItemEntity)

    // Deletar um product
    @Delete
    fun deletProduct(product: ResultsItemEntity)

    // Deletar todos os products
    @Query("DELETE FROM resultsItemEntity")
    fun deleteAll()

}
