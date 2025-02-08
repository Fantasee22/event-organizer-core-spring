package com.event_organizer_core_spring.service.impl

import com.event_organizer_core_spring.core.dto.request.GenericByIdRequest
import com.event_organizer_core_spring.dao.ServiceDao
import com.event_organizer_core_spring.dto.request.ServiceRequest
import com.event_organizer_core_spring.dto.response.ServiceResponse
import com.event_organizer_core_spring.model.Service
import com.event_organizer_core_spring.model.entity.ServiceEntity
import com.event_organizer_core_spring.model.entity.toModel
import com.event_organizer_core_spring.model.toEntity
import com.event_organizer_core_spring.service.ServiceService
import org.springframework.beans.factory.annotation.Autowired

@org.springframework.stereotype.Service
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

    override fun getServiceById(genericByIdRequest: GenericByIdRequest): ServiceResponse {
        val serviceObj = serviceDao.findServiceById(genericByIdRequest.id ?: 0)
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
                id = serviceObj.id
            )
        }
        return ServiceResponse()
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
                id = serviceObj.id
            )
        }
        return listOFServiceRes
        //region MANUAL MAPPING
//        val listOFServiceRes : MutableList<ServiceResponse> = mutableListOf<ServiceResponse>()
//        for (serviceObj in listOfServices) {
//            val serviceRes = ServiceResponse (
//                serviceCode = serviceObj.serviceCode,
//                serviceName = serviceObj.serviceName,
//                serviceType = serviceObj.serviceType,
//                description = serviceObj.description,
//                minimumPrice = serviceObj.minimumPrice,
//                maximalPrice = serviceObj.maximalPrice,
//                estimationTime = serviceObj.estimationTime,
//                termsAndCondition = serviceObj.termsAndCondition
//            )
//            listOFServiceRes.add(serviceRes)
//        }
        //endregion
    }
}