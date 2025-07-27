package com.event_organizer_core_spring.model.entity

import jakarta.persistence.*

@Entity
@Table(name = "ref_role")
class RefRoleEntity (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id: Long,

    @Column(name = "role_code", nullable = false, unique = true, length = 50)
    var roleCode: String,

    @Column(name = "role_value", nullable = false, length = 200)
    var roleValue: String,

    @Column(name = "description", nullable = true, length = 1000)
    var description: String?
)