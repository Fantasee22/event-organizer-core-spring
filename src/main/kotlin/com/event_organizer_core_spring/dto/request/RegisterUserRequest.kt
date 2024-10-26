package com.event_organizer_core_spring.dto.request

import jakarta.validation.constraints.NotEmpty

data class RegisterUserRequest (
    @NotEmpty
    val userName: String,

    @NotEmpty
    val password: String,

    @NotEmpty
    val roleCode: String,
)