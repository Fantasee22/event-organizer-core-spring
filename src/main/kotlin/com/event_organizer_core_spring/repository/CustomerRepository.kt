package com.event_organizer_core_spring.repository

import com.event_organizer_core_spring.model.entity.CustomerEntity
import org.springframework.data.jpa.repository.JpaRepository

interface CustomerRepository : JpaRepository<CustomerEntity, Long> {
}