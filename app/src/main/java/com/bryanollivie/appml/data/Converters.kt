package com.bryanollivie.appml.data

import androidx.room.TypeConverter
import com.bryanollivie.appml.data.local.entity.ResponseEntity
import com.bryanollivie.appml.data.local.entity.ResultsItemEntity
import com.bryanollivie.appml.data.remote.dto.ResponseDto
import com.bryanollivie.appml.data.remote.dto.ResultsItemDto
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object Converters {

    @TypeConverter
    fun responseDtoToEntity(dto: ResponseDto?): ResponseEntity {
        return ResponseEntity(
            query = dto?.query,
            results = productDtoListToEntityList(dto?.results),
            country_default_time_zone = dto?.country_default_time_zone
        )
    }

    @TypeConverter
    fun responseEntityToDto(entity: ResponseEntity?): ResponseDto {
        return ResponseDto(
            query = entity?.query,
            results = productEntityListToDtoList(entity?.results),
            country_default_time_zone = entity?.country_default_time_zone
        )
    }

    @TypeConverter
    fun fromResultsItemList(value: List<ResultsItemEntity?>?): String? {
        val gson = Gson()
        val type = object : TypeToken<List<ResultsItemEntity?>>() {}.type
        return gson.toJson(value, type)
    }

    @TypeConverter
    fun toResultsItemEntityList(value: String?): List<ResultsItemEntity?>? {
        val gson = Gson()
        val type = object : TypeToken<List<ResultsItemEntity?>>() {}.type
        return gson.fromJson(value, type)
    }

    @TypeConverter
    fun productDtoToEntity(dto: ResultsItemDto?): ResultsItemEntity {
        return ResultsItemEntity(
            originalPrice = dto?.originalPrice,
            title = dto?.title,
            price = dto?.price,
            thumbnail = dto?.thumbnail
        )
    }

    fun productEntityToDto(entity: ResultsItemEntity?): ResultsItemDto {
        return ResultsItemDto(
            originalPrice = entity?.originalPrice,
            title = entity?.title,
            price = entity?.price,
            thumbnail = entity?.thumbnail
            )
    }

    fun productEntityListToDtoList(dtoList: List<ResultsItemEntity?>?): List<ResultsItemDto> {
        return dtoList!!.map { productEntityToDto(it) }
    }

    fun productDtoListToEntityList(dtoList: List<ResultsItemDto?>?): List<ResultsItemEntity> {
        return dtoList!!.map { productDtoToEntity(it) }
    }
}
