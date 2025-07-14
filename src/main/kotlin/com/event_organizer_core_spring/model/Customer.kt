package com.event_organizer_core_spring.model

import com.event_organizer_core_spring.model.entity.CustomerEntity
import com.event_organizer_core_spring.model.entity.OrderEntity
import com.event_organizer_core_spring.model.entity.ServiceEntity
import java.time.LocalDateTime

class Customer (
    val id: Long? = null,
    val customerNo: String,
    val customerName: String,
    val phoneNumber: String,
    val address: String,
    val idNo: String?,
    val birthDate: LocalDateTime?,
    val email: String,
    val orders: MutableList<Order> = mutableListOf()
)

fun Customer.toEntity(): CustomerEntity {
    return CustomerEntity (
        this.id ?: 0,
        this.customerNo,
        this.customerName,
        this.phoneNumber,
        this.address,
        this.idNo,
        this.birthDate,
        this.email
    )
}

fun Customer.toEntityWithProp(): CustomerEntity {
    return CustomerEntity(
        this.id ?: 0,
        this.customerNo,
        this.customerName,
        this.phoneNumber,
        this.address,
        this.idNo,
        this.birthDate,
        this.email,
        this.orders.map { it.toEntity() }.toMutableList()
    )
}