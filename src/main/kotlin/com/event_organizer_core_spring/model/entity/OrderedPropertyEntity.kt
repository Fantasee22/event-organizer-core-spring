package com.event_organizer_core_spring.model.entity

import jakarta.persistence.*

@Entity
@Table(name = "ordered_property")
class OrderedPropertyEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    val id: Long,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", nullable = false, unique = false)
    val order: OrderEntity,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "property_id", nullable = false, unique = false)
    val property: PropertyEntity,
)