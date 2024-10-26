package com.event_organizer_core_spring.service.impl

import com.event_organizer_core_spring.dao.UserDao
import com.event_organizer_core_spring.dto.request.RegisterUserRequest
import com.event_organizer_core_spring.dto.response.RegisterUserResponse
import com.event_organizer_core_spring.model.RefUser
import com.event_organizer_core_spring.model.entity.toModel
import com.event_organizer_core_spring.model.toEntity
import com.event_organizer_core_spring.service.UserService
import org.springframework.beans.factory.annotation.Autowired

class UserServiceImpl(
    @Autowired
    val userDao: UserDao
): UserService {
    override fun registerUser(request: RegisterUserRequest): RegisterUserResponse {
        val user = RefUser(userName = request.userName, password = request.password, isLocked = false, isActive = true, roleCode = request.roleCode)
        val registeredUser = userDao.registerUser(user.toEntity()).toModel()
        return RegisterUserResponse(registeredUser.userName)
    }
}