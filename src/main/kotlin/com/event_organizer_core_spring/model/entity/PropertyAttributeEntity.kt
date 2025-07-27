package com.event_organizer_core_spring.model.entity

import jakarta.persistence.*

@Entity
@Table(name = "property_attribute")
class PropertyAttributeEntity (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id: Long,

    @Column(name = "property_attribute_code", nullable = false, unique = true, length = 50)
    var propertyAttributeCode: String,

    @Column(name = "attribute_name", nullable = false, unique = false, length = 100)
    var attributeName: String,

    @Column(name = "attribute_value", nullable = false, unique = false, length = 200)
    var attributeValue: String,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "property_id", nullable = false, unique = false)
    var property: PropertyEntity
)