package com.bryanollivie.appml.data

import androidx.room.TypeConverter
import com.bryanollivie.appml.data.local.entity.ResultsItemEntity
import com.bryanollivie.appml.data.remote.ResultsItemDto

object Converters {

    @TypeConverter
    fun productDtoToEntity(dto: ResultsItemDto?): ResultsItemEntity {
        return ResultsItemEntity(
            originalPrice = dto?.originalPrice,
            title = dto?.title,
            price = dto?.price,
            thumbnail = dto?.thumbnail,
            querySearch = "",
            dataHora = 0,


        )
    }

    fun productDtoListToEntityList(dtoList: List<ResultsItemDto?>?): List<ResultsItemEntity> {
        return dtoList!!.map { productDtoToEntity(it) }
    }
/*
    fun entityToDto(entity: User): UserDTO {
        return UserDTO(
            id = entity.id,
            name = entity.name,
            email = entity.email
            // copiar outros campos...
        )
    }

     @TypeConverter
    fun fromTimestamp(value: Long?): Date? {
        return value?.let { Date(it) }
    }

    @TypeConverter
    fun dateToTimestamp(date: Date?): Long? {
        return date?.time
    }*/
}
