package com.event_organizer_core_spring.controller

import com.event_organizer_core_spring.core.dto.request.GenericByIdRequest
import com.event_organizer_core_spring.dto.request.ServiceRequest
import com.event_organizer_core_spring.dto.response.ListServiceResponse
import com.event_organizer_core_spring.dto.response.ServiceResponse
import com.event_organizer_core_spring.service.ServiceService
import jakarta.validation.Valid
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/service")
class ServiceController (
    @Autowired
    val serviceService: ServiceService
) {
    @PostMapping("/add")
    fun addService(
        @Valid
        @RequestBody
        request: ServiceRequest
    ): ServiceResponse {
        return serviceService.addService(request)
    }

    @PostMapping("/edit")
    fun editService(
        @Valid
        @RequestBody
        request: ServiceRequest
    ): ServiceResponse {
        return serviceService.editService(request)
    }

    @PostMapping("/getById")
    fun getServiceById(
        @Valid
        @RequestBody
        request: GenericByIdRequest
    ): ServiceResponse {
        return serviceService.getServiceById(request)
    }

    @PostMapping("/getAll")
    fun getAllService(): ListServiceResponse {
        return ListServiceResponse(serviceService.getAllService())
    }

    @PostMapping("/disable")
    fun disableService(
        @Valid
        @RequestBody
        request: GenericByIdRequest
    ): ServiceResponse {
        return serviceService.disableService(request)
    }
}