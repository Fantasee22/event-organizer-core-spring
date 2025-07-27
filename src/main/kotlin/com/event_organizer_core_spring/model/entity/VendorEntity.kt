package com.event_organizer_core_spring.model.entity

import jakarta.persistence.*

@Entity
@Table(name = "vendor")
class VendorEntity (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id: Long,

    @Column(name = "vendor_code", nullable = false, unique = true, length = 50)
    var vendorCode: String,

    @Column(name = "vendor_name", nullable = false, length = 100)
    var vendorName: String,

    @Column(name = "address", nullable = false, length = 500)
    var address: String,

    @Column(name = "phone_number", nullable = false, length = 20)
    var phoneNumber: String,

    @Column(name = "email", nullable = true, length = 320)
    var email: String,

    @Column(name = "is_active", nullable = false)
    var isActive: Boolean
)