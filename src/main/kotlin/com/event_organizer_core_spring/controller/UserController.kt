package com.event_organizer_core_spring.controller

import com.event_organizer_core_spring.dto.request.RegisterUserRequest
import com.event_organizer_core_spring.dto.response.RegisterUserResponse
import com.event_organizer_core_spring.service.UserService
import jakarta.validation.Valid
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController(
    @Autowired
    val userService: UserService
) {
    @GetMapping("/user/register")
    fun registerUser(@Valid request: RegisterUserRequest): RegisterUserResponse {
        return userService.registerUser(request)
    }
}