package com.event_organizer_core_spring.model

import com.event_organizer_core_spring.model.entity.ServiceImageEntity

class ServiceImage (
    val id: Long,
    val imageData: ByteArray
//    val service_id: Long
)

fun ServiceImage.toEntity(): ServiceImageEntity {
    return ServiceImageEntity(
        this.id,
        this.imageData
    )
}