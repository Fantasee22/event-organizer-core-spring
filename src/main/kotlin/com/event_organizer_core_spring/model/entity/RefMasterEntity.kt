package com.event_organizer_core_spring.model.entity

import com.event_organizer_core_spring.model.core.BaseEntity
import jakarta.persistence.*

@Entity
@Table(name = "ref_master")
class RefMasterEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    val id: Long,

    @Column(name = "master_code", nullable = false, unique = true, length = 50)
    val masterCode: String,

    @Column(name = "master_value", nullable = false, length = 200)
    val masterValue: String,

    @Column(name = "description", nullable = true, length = 1000)
    val description: String?
) : BaseEntity() //ToDo: check if base entity is declared right way