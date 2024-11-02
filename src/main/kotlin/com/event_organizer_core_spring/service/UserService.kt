package com.event_organizer_core_spring.service

import com.event_organizer_core_spring.dto.request.RegisterUserRequest
import com.event_organizer_core_spring.dto.response.RegisterUserResponse

interface UserService {
    fun registerUser(request: RegisterUserRequest): RegisterUserResponse
}