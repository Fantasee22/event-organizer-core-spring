package com.event_organizer_core_spring.model.entity

import jakarta.persistence.*
import java.time.LocalDateTime


@Entity
@Table(name = "employee")
class EmployeeEntity (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id: Long,

    @Column(name = "employee_no", nullable = false, unique = true, length = 50)
    var employeeNo: String,

    @Column(name = "employee_name", nullable = false, length = 100)
    var employeeName: String,

    @Column(name = "phone_number", nullable = true, length = 20)
    var phoneNumber: String?,

    @Column(name = "is_active", nullable = false)
    var isActive: Boolean,

    @Column(name = "id_no", nullable = false, length = 50)
    var idNo: String,

    @Column(name = "birth_date", nullable = true)
    var birthDate: LocalDateTime?,

    @OneToMany(mappedBy = "pic", fetch = FetchType.LAZY)
    var orders: MutableList<OrderEntity> = mutableListOf()

) {
    constructor() : this (
        id = 0L,
        employeeNo = "",
        employeeName = "",
        phoneNumber = null,
        isActive = false,
        idNo = "",
        birthDate = null,
        orders = mutableListOf()
    )
}