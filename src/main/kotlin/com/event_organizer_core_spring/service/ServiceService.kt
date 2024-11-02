package com.event_organizer_core_spring.service

import com.event_organizer_core_spring.dto.request.ServiceRequest
import com.event_organizer_core_spring.dto.response.ServiceResponse
import org.springframework.stereotype.Service

@Service
interface ServiceService {
    fun addService(serviceRequest: ServiceRequest) : ServiceResponse
    fun editService(serviceRequest: ServiceRequest) : ServiceResponse
}