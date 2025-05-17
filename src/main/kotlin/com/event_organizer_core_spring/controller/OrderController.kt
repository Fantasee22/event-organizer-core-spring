package com.event_organizer_core_spring.controller

import com.event_organizer_core_spring.dto.response.order.ListOrderResponse
import com.event_organizer_core_spring.service.OrderService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/order")
class OrderController (
    @Autowired
    val orderService: OrderService
) {
    @PostMapping("/getAll")
    fun getAllOrder(): ListOrderResponse {
        return ListOrderResponse(orderService.getAllOrder())
    }
}