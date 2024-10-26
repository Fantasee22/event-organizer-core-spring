package com.event_organizer_core_spring.dao

import com.event_organizer_core_spring.model.entity.RefUserEntity
import org.springframework.stereotype.Component

@Component
interface UserDao {
    fun registerUser(userEntity: RefUserEntity): RefUserEntity
}