package com.event_organizer_core_spring.dao.impl

import com.event_organizer_core_spring.dao.UserDao
import com.event_organizer_core_spring.model.entity.RefUserEntity
import com.event_organizer_core_spring.repository.UserRepository

class UserDaoImpl(
    val userRepository: UserRepository
) : UserDao {
    override fun registerUser(userEntity: RefUserEntity): RefUserEntity {
        return userRepository.save(userEntity)
    }
}