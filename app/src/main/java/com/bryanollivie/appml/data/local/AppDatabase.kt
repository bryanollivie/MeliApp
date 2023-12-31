package com.bryanollivie.appml.data.local
import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [ResponseEntity::class, ResultsItemEntity::class], version = 1)
abstract class AppMLDatabase : RoomDatabase() {

    // DAOs que serão utilizados na base de dados
    abstract fun productDao(): ProductDao

}
