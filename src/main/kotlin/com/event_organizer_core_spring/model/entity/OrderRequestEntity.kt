package com.event_organizer_core_spring.model.entity

import jakarta.persistence.*

@Entity
class OrderRequestEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    val id: Long,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", nullable = false, unique = false)
    val order: OrderEntity,

    @Column(name = "property_attribute_code", nullable = false, unique = true)
    val propertyAttributeCode: String,

    @Column(name = "request_value", nullable = false, unique = true)
    val requestValue: String
)