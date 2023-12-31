package com.bryanollivie.appml.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ResponseEntity(

    @PrimaryKey val query: String? = null,
    val results: List<ResultsItemEntity?>? = null,
    val country_default_time_zone: String? = null
)