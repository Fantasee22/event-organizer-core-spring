package com.event_organizer_core_spring.dao

import com.event_organizer_core_spring.model.entity.RefUserEntity

interface UserDao {
    fun registerUser(userEntity: RefUserEntity): RefUserEntity
}