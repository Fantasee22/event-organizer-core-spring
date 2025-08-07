package com.event_organizer_core_spring.service

import com.event_organizer_core_spring.core.dto.request.GenericByIdRequest
import com.event_organizer_core_spring.dto.request.order.OrderRequest
import com.event_organizer_core_spring.dto.response.order.OrderResponse
import com.event_organizer_core_spring.generic.GenericService
import com.event_organizer_core_spring.model.entity.OrderEntity

interface OrderService : GenericService<OrderEntity, Long> {
    fun addOrder(orderRequest: OrderRequest) : OrderResponse
    fun editOrder(orderRequest: OrderRequest) : OrderResponse
    fun getOrderById (genericByIdRequest: GenericByIdRequest) : OrderResponse
    fun getAllOrder() : List<OrderResponse>
}