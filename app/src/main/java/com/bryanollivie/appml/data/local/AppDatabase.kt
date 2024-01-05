package com.bryanollivie.appml.data.local
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.bryanollivie.appml.data.Converters
import com.bryanollivie.appml.data.local.dao.ProductDao
import com.bryanollivie.appml.data.local.entity.ResponseEntity
import com.bryanollivie.appml.data.local.entity.ResultsItemEntity

@Database(entities = [ResponseEntity::class,ResultsItemEntity::class], version = 1)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun productDao(): ProductDao
}