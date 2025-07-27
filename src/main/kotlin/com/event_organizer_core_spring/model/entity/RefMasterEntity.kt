package com.event_organizer_core_spring.model.entity

import com.event_organizer_core_spring.core.model.BaseEntity
import jakarta.persistence.*

@Entity
@Table(name = "ref_master")
class RefMasterEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id: Long,

    @Column(name = "master_code", nullable = false, unique = true, length = 50)
    var masterCode: String,

    @Column(name = "master_value", nullable = false, length = 200)
    var masterValue: String,

    @Column(name = "description", nullable = true, length = 1000)
    var description: String?
) : BaseEntity() //ToDo: check if base entity is declared right way