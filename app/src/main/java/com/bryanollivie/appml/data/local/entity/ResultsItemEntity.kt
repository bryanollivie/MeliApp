package com.bryanollivie.appml.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "products")
data class ResultsItemEntity(
    @PrimaryKey val id: String? = null,
    val originalPrice: Int? = null,
    val title: String? = null,
    val useThumbnailId: Boolean? = null,
    val categoryId: String? = null,
    val price: String? = null,
    val thumbnail: String? = "",
    val permalink: String? = null,
    val officialStoreName: String? = null,
)