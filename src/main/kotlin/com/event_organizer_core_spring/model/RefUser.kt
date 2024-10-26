package com.event_organizer_core_spring.model

import com.event_organizer_core_spring.model.entity.RefUserEntity

class RefUser(
    val id: Long? = null,

    val userName: String,

    val password: String,

    val isLocked: Boolean,

    val isActive: Boolean,

    val roleCode: String,
)

fun RefUser.toEntity(): RefUserEntity {
    return RefUserEntity(
        this.id,
        this.userName,
        this.password,
        this.isLocked,
        this.isActive,
        this.roleCode
    )
}