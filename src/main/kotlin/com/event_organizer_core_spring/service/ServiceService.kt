package com.event_organizer_core_spring.service

import com.event_organizer_core_spring.core.dto.request.GenericByIdRequest
import com.event_organizer_core_spring.dto.request.ServiceRequest
import com.event_organizer_core_spring.dto.response.ServiceResponse
import org.springframework.stereotype.Service

interface ServiceService {
    fun addService(serviceRequest: ServiceRequest) : ServiceResponse
    fun editService(serviceRequest: ServiceRequest) : ServiceResponse
    fun getServiceById (genericByIdRequest: GenericByIdRequest) : ServiceResponse
    fun getAllService() : List<ServiceResponse>
}