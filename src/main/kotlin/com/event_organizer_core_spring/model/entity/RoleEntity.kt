package com.event_organizer_core_spring.model.entity

import jakarta.persistence.*

@Entity
@Table(name = "role")
class RoleEntity (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    val id: Long,

    @Column(name = "role_code", nullable = false, unique = true, length = 50)
    val roleCode: String,

    @Column(name = "role_value", nullable = false, length = 200)
    val roleValue: String,

    @Column(name = "description", nullable = true, length = 1000)
    val description: String?
)