package com.event_organizer_core_spring.repository

import com.event_organizer_core_spring.model.entity.ServiceEntity
import org.springframework.data.jpa.repository.JpaRepository

interface ServiceRepository : JpaRepository<ServiceEntity, Long> {

}