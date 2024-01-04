package com.bryanollivie.appml.data.local
import androidx.room.Database
import androidx.room.RoomDatabase
import com.bryanollivie.appml.data.local.entity.User

/*

@Database(entities = [ResponseEntity::class, ResultsItemEntity::class], version = 1)
abstract class AppMLDatabase : RoomDatabase() {

    // DAOs que serão utilizados na base de dados
    abstract fun productDao(): ProductDao

}
*/
@Database(entities = [User::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}