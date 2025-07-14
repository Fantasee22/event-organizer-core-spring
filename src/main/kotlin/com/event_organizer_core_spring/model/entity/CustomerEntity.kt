package com.event_organizer_core_spring.model.entity

import com.event_organizer_core_spring.model.Customer
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
    var customerNo: String,

    @Column(name = "customer_name", nullable = false)
    var customerName: String,

    @Column(name = "phone_number", nullable = false, length = 20)
    var phoneNumber: String,

    @Column(name = "address", nullable = false, length = 500)
    var address: String,

    @Column(name = "id_no", nullable = true, length = 50)
    var idNo: String?,

    @Column(name = "birth_date", nullable = true)
    var birthDate: LocalDateTime?,

    @Column(name = "email", nullable = false, length = 320)
    var email: String,

    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    var orders: MutableList<OrderEntity> = mutableListOf()
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
        orders = mutableListOf()
    )
}

fun CustomerEntity.toModel() : Customer {
    return Customer(
        id = this.id,
        customerNo = this.customerNo,
        customerName = this.customerName,
        phoneNumber = this.phoneNumber,
        address = this.address,
        idNo = this.idNo,
        birthDate = this.birthDate,
        email = this.email
    )
}

fun CustomerEntity.toModelWithProp() : Customer {
    return Customer(
        id = this.id,
        customerNo = this.customerNo,
        customerName = this.customerName,
        phoneNumber = this.phoneNumber,
        address = this.address,
        idNo = this.idNo,
        birthDate = this.birthDate,
        email = this.email,
        orders = this.orders.map { it.toModel() }.toMutableList()
    )
}