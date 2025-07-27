package com.event_organizer_core_spring.model

import com.event_organizer_core_spring.constant.OrderStatus
import com.event_organizer_core_spring.model.entity.*
import java.time.LocalDateTime

class Order (
    val id: Long? = null,
    val orderNo: String,
    val totalPrice: Double,
    val totalPaid: Double,
    val orderStatus: OrderStatus,
    val startTime: LocalDateTime,
    val endTime: LocalDateTime,
    val service: ServiceEntity,
    val customer: CustomerEntity,
    val pic: EmployeeEntity,
    val payments: MutableList<PaymentEntity> = mutableListOf(),
    val orderRequests: MutableList<OrderRequestEntity> = mutableListOf(),
    val orderedProperties: MutableList<OrderedPropertyEntity> = mutableListOf()
)

fun Order.toEntity(): OrderEntity {
    return OrderEntity (
        this.id ?: 0,
        this.orderNo,
        this.totalPrice,
        this.totalPaid,
        this.orderStatus,
        this.startTime,
        this.endTime,
        this.service,
        this.customer,
        this.pic
    )
}

fun Order.toEntityWithProp(): OrderEntity {
    return OrderEntity (
        this.id ?: 0,
        this.orderNo,
        this.totalPrice,
        this.totalPaid,
        this.orderStatus,
        this.startTime,
        this.endTime,
        this.service,
        this.customer,
        this.pic,
//        this.payments.map { it.toEntity() },
//        this.orderRequests,
//        this.orderedProperties //TODO: after dev toEntity method
    )
}