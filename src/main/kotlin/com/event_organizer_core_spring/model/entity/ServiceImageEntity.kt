package com.event_organizer_core_spring.model.entity

import com.event_organizer_core_spring.model.ServiceImage
import jakarta.persistence.*

@Entity
@Table(name = "service_image")
class ServiceImageEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id: Long,

    @Lob
    @Column(name = "image_data", nullable = false)
    var imageData: ByteArray
)

fun ServiceImageEntity.toModel() : ServiceImage {
    return ServiceImage(
        this.id,
        this.imageData
    )
}