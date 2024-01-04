package com.bryanollivie.appml.data.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "products")
data class ResultsItemEntity(
    @PrimaryKey(autoGenerate = true) @NonNull @ColumnInfo(name = "product_id") val id: Int = 0,
    @ColumnInfo(name = "original_price") val originalPrice: Int? = 0,
    @ColumnInfo(name = "title") val title: String? = "",
    //@ColumnInfo(name = "use_thumbnail_id") val useThumbnailId: Boolean? = false,
    //@ColumnInfo(name = "categoryId") val categoryId: String? = "",
    @ColumnInfo(name = "price") val price: String? = "",
    @ColumnInfo(name = "thumbnail") val thumbnail: String? = "",
    @ColumnInfo(name = "query_search") val querySearch: String? = "",
    @ColumnInfo(name = "query_search_datetime") val dataHora: Long? = 0,
    //@ColumnInfo(name = "product_id") val permalink: String? = "",
    //@ColumnInfo(name = "product_id") val officialStoreName: String? = "",
)