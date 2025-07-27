package com.event_organizer_core_spring.model.entity

import jakarta.persistence.*

@Entity
@Table(name = "property")
class PropertyEntity (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id: Long,

    @Column(name = "property_code", nullable = false, unique = true, length = 50)
    var propertyCode: String,

    @Column(name = "property_name", nullable = false, length = 100)
    var propertyName: String,

    @Column(name = "description", nullable = true, length = 1000)
    var description: String,

    @Column(name = "property_type", nullable = false, length = 50)
    var propertyType: String,

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vendor_id", nullable = true)
    var vendor: VendorEntity?,

    @OneToMany(mappedBy = "property", fetch = FetchType.LAZY)
    var orderedProperties: MutableList<OrderedPropertyEntity> = mutableListOf(),

    @OneToMany(mappedBy = "property", fetch = FetchType.LAZY)
    var attributes: MutableList<PropertyAttributeEntity> = mutableListOf(),

    @OneToMany(cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    @JoinColumn(name = "property_id")
    var images: MutableList<PropertyImageEntity> = mutableListOf(),
)