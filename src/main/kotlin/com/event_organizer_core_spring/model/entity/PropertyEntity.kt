package com.event_organizer_core_spring.model.entity

import jakarta.persistence.*

@Entity
@Table(name = "property")
class PropertyEntity (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    val id: Long,

    @Column(name = "property_code", nullable = false, unique = true, length = 50)
    val propertyCode: String,

    @Column(name = "property_name", nullable = false, length = 100)
    val propertyName: String,

    @Column(name = "description", nullable = true, length = 1000)
    val description: String,

    @Column(name = "property_type", nullable = false, length = 50)
    val propertyType: String,

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vendor_id", nullable = true)
    var vendor: VendorEntity?,

    @OneToMany(mappedBy = "property", fetch = FetchType.LAZY)
    val orderedProperties: List<OrderedPropertyEntity> = listOf(),

    @OneToMany(mappedBy = "property", fetch = FetchType.LAZY)
    val attributes: List<PropertyAttributeEntity> = listOf(),

    @OneToMany(cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    @JoinColumn(name = "property_id")
    val images: List<PropertyImageEntity> = listOf(),
)