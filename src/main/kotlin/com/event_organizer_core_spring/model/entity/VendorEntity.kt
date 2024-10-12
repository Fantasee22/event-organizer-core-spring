package com.event_organizer_core_spring.model.entity

import jakarta.persistence.*

@Entity
@Table(name = "vendor")
class VendorEntity (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    val id: Long,

    @Column(name = "vendor_code", nullable = false, unique = true, length = 50)
    val vendorCode: String,

    @Column(name = "vendor_name", nullable = false, length = 100)
    val vendorName: String,

    @Column(name = "address", nullable = false, length = 500)
    val address: String,

    @Column(name = "phone_number", nullable = false, length = 20)
    val phoneNumber: String,

    @Column(name = "email", nullable = true, length = 320)
    val email: String,

    @Column(name = "is_active", nullable = false)
    val isActive: Boolean
)