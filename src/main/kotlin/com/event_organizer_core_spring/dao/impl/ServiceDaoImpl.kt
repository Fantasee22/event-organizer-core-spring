package com.event_organizer_core_spring.dao.impl

import com.event_organizer_core_spring.dao.ServiceDao
import com.event_organizer_core_spring.model.entity.ServiceEntity
import com.event_organizer_core_spring.repository.ServiceRepository
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Component
import org.springframework.web.server.ResponseStatusException

@Component
class ServiceDaoImpl (
    val serviceRepository: ServiceRepository
) : ServiceDao {
    override fun addService(serviceEntity: ServiceEntity): ServiceEntity {
        return serviceRepository.save(serviceEntity)
    }

    override fun editService(serviceEntity: ServiceEntity): ServiceEntity {
        findServiceById(serviceEntity.id ?: 0, true)
        return serviceRepository.save(serviceEntity)
    }

    override fun findServiceById(id: Long): ServiceEntity {
        return serviceRepository.findById(id).orElseThrow {
            ResponseStatusException(HttpStatus.NOT_FOUND, "Service not found")
        }
    }

    override fun findServiceById(id: Long, useException: Boolean): ServiceEntity? {
        if (useException) {
            return serviceRepository.findById(id).orElseThrow {
                ResponseStatusException(HttpStatus.NOT_FOUND, "Service not found")
            }
        }
        return serviceRepository.findById(id).orElse(null)
    }

    override fun getAllService(): List<ServiceEntity> {
        return serviceRepository.findAll()
    }

    override fun disableService(id: Long): ServiceEntity? {
        var serviceEntity = findServiceById(id ?: 0, true)
        if (serviceEntity != null) {
            serviceEntity.isActive = false
            return serviceRepository.save(serviceEntity)
        } else {
            return serviceEntity
        }
    }
}