package com.event_organizer_core_spring.model

import com.event_organizer_core_spring.model.entity.RefUserEntity
import com.event_organizer_core_spring.model.entity.ServiceImageEntity
import jakarta.persistence.Column
import jakarta.persistence.Lob

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