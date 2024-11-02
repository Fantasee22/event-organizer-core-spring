package com.event_organizer_core_spring.controller

import com.event_organizer_core_spring.dto.request.ServiceRequest
import com.event_organizer_core_spring.dto.response.ServiceResponse
import com.event_organizer_core_spring.service.ServiceService
import jakarta.validation.Valid
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/service")
class ServiceController (
    @Autowired
    val serviceService: ServiceService
) {
    @GetMapping("/add")
    fun addService(@Valid request: ServiceRequest): ServiceResponse {
        return serviceService.addService(request)
    }

    @GetMapping("/edit")
    fun editService(@Valid request: ServiceRequest): ServiceResponse {
        return serviceService.editService(request)
    }
}