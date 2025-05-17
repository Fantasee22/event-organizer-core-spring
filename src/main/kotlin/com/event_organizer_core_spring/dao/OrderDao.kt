package com.event_organizer_core_spring.dao;

import com.event_organizer_core_spring.model.entity.OrderEntity;

public interface OrderDao {
    fun addOrder(orderEntity: OrderEntity): OrderEntity
    fun editOrder(orderEntity: OrderEntity): OrderEntity
    fun findOrderById(id: Long): OrderEntity?
    fun findOrderById(id: Long, useException: Boolean): OrderEntity?
    fun getAllOrder(): List<OrderEntity>
}
