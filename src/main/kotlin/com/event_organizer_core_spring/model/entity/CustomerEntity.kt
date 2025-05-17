package com.event_organizer_core_spring.model.entity

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "customer")
class CustomerEntity (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    val id: Long,

    @Column(name = "customer_no", nullable = false, unique = true, length = 50)
    val customerNo: String,

    @Column(name = "customer_name", nullable = false)
    val customerName: String,

    @Column(name = "phone_number", nullable = false, length = 20)
    val phoneNumber: String,

    @Column(name = "address", nullable = false, length = 500)
    val address: String,

    @Column(name = "id_no", nullable = true, length = 50)
    val idNo: String?,

    @Column(name = "birth_date", nullable = true)
    val birthDate: LocalDateTime?,

    @Column(name = "email", nullable = false, length = 320)
    val email: String,

    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    val orders: List<OrderEntity> = listOf()
) {
    constructor() : this (
        id = 0L,
        customerNo = "",
        customerName = "",
        phoneNumber = "",
        address = "",
        idNo = null,
        birthDate = null,
        email = "",
        orders = listOf()
    )
}