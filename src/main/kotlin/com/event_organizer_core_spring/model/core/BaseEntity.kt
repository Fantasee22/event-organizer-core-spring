package com.event_organizer_core_spring.model.core

import jakarta.persistence.Column
import jakarta.persistence.MappedSuperclass
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.time.LocalDateTime

@MappedSuperclass
public abstract class BaseEntity { //ToDo: check if base entity is declared right way
    @CreatedDate
    @Column(name = "dtm_crt", nullable = true)
    val dateCreate: LocalDateTime? = null

    @LastModifiedDate
    @Column(name = "dtm_upd", nullable = true)
    val dateUpdate: LocalDateTime? = null

    @Column(name = "usr_crt", nullable = true, length = 100)
    val userCreate: String? = null

    @Column(name = "usr_upd", nullable = true, length = 100)
    val userUpdate: String? = null
}

//ToDo:
//
