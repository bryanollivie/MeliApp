package com.bryanollivie.appml.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.bryanollivie.appml.data.local.entity.User

/*
@Dao
interface UserDao {
    @Query("SELECT * FROM 'users'")
    fun getAll(): List<User>

    @Query("SELECT * FROM users WHERE rowid IN (:userIds)")
    fun loadAllByIds(userIds: IntArray): List<User>

    @Query("SELECT * FROM users WHERE first_name LIKE :first AND " +
            "last_name LIKE :last LIMIT 1")
    fun findByName(first: String, last: String): User

    @Insert
    fun insertAll(users: List<User>)

    @Delete
    fun delete(user: User)
}*/
