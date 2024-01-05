package com.bryanollivie.appml.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

//@Fts4
@Entity(tableName = "users")
data class User(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "user_id") val userId: Int? = 0,
    @ColumnInfo(name = "first_name") val firstName: String? = "",
    @ColumnInfo(name = "last_name") val lastName: String? = ""
)