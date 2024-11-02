package com.event_organizer_core_spring.model

import com.event_organizer_core_spring.model.entity.OrderEntity
import com.event_organizer_core_spring.model.entity.ServiceEntity
import com.event_organizer_core_spring.model.entity.ServiceImageEntity
import jakarta.persistence.*

class Service (
    val id: Long? = null,

    val serviceCode: String,

    val serviceName: String,

    val serviceType: String,

    val description: String,

    val minimumPrice: Double,

    val maximalPrice: Double,

    val estimationTime: Float,

    val termsAndCondition: String,

    val images: List<ServiceImage> = listOf(),

    val mappingServiceProperties: List<String> = listOf(),

    val orders: List<Order> = listOf()
)

fun Service.toEntity(): ServiceEntity {
    return ServiceEntity(
        this.id,
        this.serviceCode,
        this.serviceName,
        this.serviceType,
        this.description,
        this.minimumPrice,
        this.maximalPrice,
        this.estimationTime,
        this.termsAndCondition
//        this.images.map { it.toEntity() },
//        this.mappingServiceProperties,
//        this.orders.map { it.toEntity() } //TODO: after order api developed
    )
}

fun Service.toEntityWithProp(): ServiceEntity {
    return ServiceEntity(
        this.id,
        this.serviceCode,
        this.serviceName,
        this.serviceType,
        this.description,
        this.minimumPrice,
        this.maximalPrice,
        this.estimationTime,
        this.termsAndCondition,
        this.images.map { it.toEntity() },
        this.mappingServiceProperties,
//        this.orders.map { it.toEntity() } //TODO: after order api developed
    )
}