package com.event_organizer_core_spring.service.impl

import com.event_organizer_core_spring.core.dto.request.GenericByIdRequest
import com.event_organizer_core_spring.dao.ServiceDao
import com.event_organizer_core_spring.dto.request.ServiceRequest
import com.event_organizer_core_spring.dto.response.ServiceResponse
import com.event_organizer_core_spring.generic.GenericServiceImpl
import com.event_organizer_core_spring.model.Service
import com.event_organizer_core_spring.model.entity.ServiceEntity
import com.event_organizer_core_spring.model.entity.toModel
import com.event_organizer_core_spring.model.toEntity
import com.event_organizer_core_spring.repository.ServiceRepository
import com.event_organizer_core_spring.service.ServiceService
import org.springframework.beans.factory.annotation.Autowired

@org.springframework.stereotype.Service
class ServiceServiceImpl (
    @Autowired
    val serviceDao: ServiceDao,
    @Autowired
    val serviceRepository: ServiceRepository
) : GenericServiceImpl<ServiceEntity, Long>(serviceRepository), ServiceService {
    override fun addService(serviceRequest: ServiceRequest): ServiceResponse {
        val service = Service(
            serviceCode = serviceRequest.serviceCode,
            serviceName = serviceRequest.serviceName,
            serviceType = serviceRequest.serviceType,
            description = serviceRequest.description,
            minimumPrice = serviceRequest.minimumPrice,
            maximalPrice = serviceRequest.maximalPrice,
            estimationTime = serviceRequest.estimationTime,
            termsAndCondition = serviceRequest.termsAndCondition,
            isActive = true
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
            id = serviceRequest.id,
            serviceCode = serviceRequest.serviceCode,
            serviceName = serviceRequest.serviceName,
            serviceType = serviceRequest.serviceType,
            description = serviceRequest.description,
            minimumPrice = serviceRequest.minimumPrice,
            maximalPrice = serviceRequest.maximalPrice,
            estimationTime = serviceRequest.estimationTime,
            termsAndCondition = serviceRequest.termsAndCondition,
            isActive = serviceRequest.isActive
        )

        val editedService = serviceDao.editService(service.toEntity()).toModel()

        return ServiceResponse(
            serviceName = editedService.serviceName,
            serviceCode = editedService.serviceCode,
            id = editedService.id
        )
    }

    override fun getServiceById(genericByIdRequest: GenericByIdRequest): ServiceResponse {
        val serviceObj = serviceDao.findServiceById(genericByIdRequest.id ?: 0, useException = false)
        if (serviceObj != null) {
            return ServiceResponse(
                serviceCode = serviceObj.serviceCode,
                serviceName = serviceObj.serviceName,
                serviceType = serviceObj.serviceType,
                description = serviceObj.description,
                minimumPrice = serviceObj.minimumPrice,
                maximalPrice = serviceObj.maximalPrice,
                estimationTime = serviceObj.estimationTime,
                termsAndCondition = serviceObj.termsAndCondition,
                isActive = serviceObj.isActive,
                id = serviceObj.id
            )
        }
        return ServiceResponse(id = 0)
    }

    override fun getAllService() : List<ServiceResponse> {
        val listOfServices : List<ServiceEntity> = serviceDao.getAllService()
        val listOFServiceRes: List<ServiceResponse> = listOfServices.map { serviceObj ->
            ServiceResponse(
                serviceCode = serviceObj.serviceCode,
                serviceName = serviceObj.serviceName,
                serviceType = serviceObj.serviceType,
                description = serviceObj.description,
                minimumPrice = serviceObj.minimumPrice,
                maximalPrice = serviceObj.maximalPrice,
                estimationTime = serviceObj.estimationTime,
                termsAndCondition = serviceObj.termsAndCondition,
                isActive = serviceObj.isActive,
                id = serviceObj.id
            )
        }
        return listOFServiceRes
    }

    override fun disableService(genericByIdRequest: GenericByIdRequest): ServiceResponse {
        val disabledService = serviceDao.disableService(genericByIdRequest.id ?: 0)
        if (disabledService != null) {
            return ServiceResponse(
                serviceName = disabledService.serviceName,
                serviceCode = disabledService.serviceCode,
                isActive = disabledService.isActive,
                id = disabledService.id
            )
        }
        return ServiceResponse(id = 0)
    }
}