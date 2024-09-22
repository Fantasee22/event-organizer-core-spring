package com.event_organizer_core_spring.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController {
    @GetMapping("/api/user/")
    fun testController(): String {
        return "Hello World"
    }
}