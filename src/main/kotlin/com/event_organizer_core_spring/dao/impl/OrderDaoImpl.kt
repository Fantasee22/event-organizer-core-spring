package com.event_organizer_core_spring.dao.impl

import com.event_organizer_core_spring.dao.OrderDao
import com.event_organizer_core_spring.model.entity.OrderEntity
import com.event_organizer_core_spring.repository.OrderRepository
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Component
import org.springframework.web.server.ResponseStatusException

@Component
class OrderDaoImpl (
    val orderRepository: OrderRepository
) : OrderDao {
    override fun addOrder(orderEntity: OrderEntity): OrderEntity {
        return orderRepository.save(orderEntity)
    }

    override fun editOrder(orderEntity: OrderEntity): OrderEntity {
        findOrderById(orderEntity.id ?: 0, true)
        return orderRepository.save(orderEntity)
    }

    override fun findOrderById(id: Long): OrderEntity {
        return orderRepository.findById(id).orElseThrow {
            ResponseStatusException(HttpStatus.NOT_FOUND, "Service not found")
        }
    }

    override fun findOrderById(id: Long, useException: Boolean): OrderEntity? {
        if (useException) {
            return orderRepository.findById(id).orElseThrow {
                ResponseStatusException(HttpStatus.NOT_FOUND, "Service not found")
            }
        }
        return orderRepository.findById(id).orElse(null)
    }

    override fun getAllOrder(): List<OrderEntity> {
        return orderRepository.findAll()
    }

}