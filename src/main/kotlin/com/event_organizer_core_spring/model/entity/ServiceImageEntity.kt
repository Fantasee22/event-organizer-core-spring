package com.event_organizer_core_spring.model.entity

import jakarta.persistence.*

@Entity
@Table(name = "service_image")
class ServiceImageEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    val id: Long,

    @Lob
    @Column(name = "image_data", nullable = false)
    val imageData: ByteArray
)