package com.event_organizer_core_spring.repository

import com.event_organizer_core_spring.model.entity.OrderEntity
import org.springframework.data.jpa.repository.JpaRepository

interface OrderRepository : JpaRepository<OrderEntity, Long> {

}