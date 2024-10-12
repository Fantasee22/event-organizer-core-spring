package com.event_organizer_core_spring.model.entity

import jakarta.persistence.*
import java.time.LocalDateTime


@Entity
@Table(name = "employee")
class EmployeeEntity (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    val id: Long,

    @Column(name = "employee_no", nullable = false, unique = true, length = 50)
    val employeeNo: String,

    @Column(name = "employee_name", nullable = false)
    val employeeName: String,

    @Column(name = "phone_number", nullable = true, length = 20)
    val phoneNumber: String?,

    @Column(name = "is_active", nullable = false)
    val isActive: Boolean,

    @Column(name = "id_no", nullable = false, length = 50)
    val idNo: String,

    @Column(name = "birth_date", nullable = true)
    val birthDate: LocalDateTime?,

    @OneToMany(mappedBy = "pic", fetch = FetchType.LAZY)
    val orders: List<OrderEntity> = listOf()

)