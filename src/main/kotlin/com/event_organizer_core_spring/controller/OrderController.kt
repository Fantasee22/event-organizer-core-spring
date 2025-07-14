package com.event_organizer_core_spring.controller

import com.event_organizer_core_spring.core.dto.request.GenericByIdRequest
import com.event_organizer_core_spring.dto.request.ServiceRequest
import com.event_organizer_core_spring.dto.request.order.OrderRequest
import com.event_organizer_core_spring.dto.response.ServiceResponse
import com.event_organizer_core_spring.dto.response.order.ListOrderResponse
import com.event_organizer_core_spring.dto.response.order.OrderResponse
import com.event_organizer_core_spring.service.OrderService
import jakarta.validation.Valid
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/order")
class OrderController (
    @Autowired
    val orderService: OrderService
) {
    @PostMapping("/add")
    fun addOrder(
        @Valid
        @RequestBody
        request: OrderRequest
    ): OrderResponse {
        return orderService.addOrder(request)
    }

    @PostMapping("/edit")
    fun editService(
        @Valid
        @RequestBody
        request: OrderRequest
    ): OrderResponse {
        return orderService.editOrder(request)
    }

    @PostMapping("/getById")
    fun getServiceById(
        @Valid
        @RequestBody
        request: GenericByIdRequest
    ): OrderResponse {
        return orderService.getOrderById(request)
    }

    @PostMapping("/getAll")
    fun getAllOrder(): ListOrderResponse {
        return ListOrderResponse(orderService.getAllOrder())
    }
}