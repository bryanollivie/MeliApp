package com.bryanollivie.appml.data.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "result_search")
data class ResponseEntity(
    @PrimaryKey(autoGenerate = true) @NonNull @ColumnInfo(name = "id") val id: Int = 0,
    @ColumnInfo(name = "query") val query: String? = "",
    @ColumnInfo(name = "results") val results: List<ResultsItemEntity?>? = emptyList(),
    @ColumnInfo(name = "country_default_time_zone") val country_default_time_zone: String? = ""
)