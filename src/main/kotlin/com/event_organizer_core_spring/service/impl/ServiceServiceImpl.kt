package com.event_organizer_core_spring.service.impl

import com.event_organizer_core_spring.dao.ServiceDao
import com.event_organizer_core_spring.dto.request.ServiceRequest
import com.event_organizer_core_spring.dto.response.ServiceResponse
import com.event_organizer_core_spring.model.Service
import com.event_organizer_core_spring.model.entity.toModel
import com.event_organizer_core_spring.model.toEntity
import com.event_organizer_core_spring.service.ServiceService
import org.springframework.beans.factory.annotation.Autowired

class ServiceServiceImpl (
    @Autowired
    val serviceDao: ServiceDao
) : ServiceService {
    override fun addService(serviceRequest: ServiceRequest): ServiceResponse {
        val service = Service(
            serviceCode = serviceRequest.serviceCode,
            serviceName = serviceRequest.serviceName,
            serviceType = serviceRequest.serviceType,
            description = serviceRequest.description,
            minimumPrice = serviceRequest.minimumPrice,
            maximalPrice = serviceRequest.maximalPrice,
            estimationTime = serviceRequest.estimationTime,
            termsAndCondition = serviceRequest.termsAndCondition
        )

        val addedService = serviceDao.addService(service.toEntity()).toModel()

        return ServiceResponse(
            serviceName = addedService.serviceName,
            serviceCode = addedService.serviceCode,
            id = addedService.id
        )
    }

    override fun editService(serviceRequest: ServiceRequest): ServiceResponse {
        val service = Service(
            serviceCode = serviceRequest.serviceCode,
            serviceName = serviceRequest.serviceName,
            serviceType = serviceRequest.serviceType,
            description = serviceRequest.description,
            minimumPrice = serviceRequest.minimumPrice,
            maximalPrice = serviceRequest.maximalPrice,
            estimationTime = serviceRequest.estimationTime,
            termsAndCondition = serviceRequest.termsAndCondition
        )

        val editedService = serviceDao.editService(service.toEntity()).toModel()

        return ServiceResponse(
            serviceName = editedService.serviceName,
            serviceCode = editedService.serviceCode,
            id = editedService.id
        )
    }
}