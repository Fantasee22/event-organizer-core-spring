package com.event_organizer_core_spring.dao

import com.event_organizer_core_spring.model.entity.ServiceEntity
import org.springframework.stereotype.Component

interface ServiceDao {
    fun addService(serviceEntity: ServiceEntity): ServiceEntity
    fun editService(serviceEntity: ServiceEntity): ServiceEntity
    fun findServiceById(id: Long): ServiceEntity
    fun findServiceById(id: Long, useException: Boolean): ServiceEntity
}