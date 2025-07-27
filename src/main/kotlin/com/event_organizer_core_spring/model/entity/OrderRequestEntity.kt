package com.event_organizer_core_spring.model.entity

import jakarta.persistence.*

@Entity
@Table(name = "order_request")
class OrderRequestEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id: Long,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", nullable = false, unique = false)
    var order: OrderEntity,

    @Column(name = "property_attribute_code", nullable = false, unique = true)
    var propertyAttributeCode: String,

    @Column(name = "request_value", nullable = false, unique = true)
    var requestValue: String
)