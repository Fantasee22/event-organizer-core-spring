package com.event_organizer_core_spring.dto.response.order

import com.event_organizer_core_spring.constant.OrderStatus
import com.event_organizer_core_spring.core.dto.response.GenericByIdResponse
import java.time.LocalDateTime

class OrderResponse (
    override val id: Long? = null,
    val orderNo: String = "",
    val totalPrice: Double = 0.0,
    val totalPaid: Double = 0.0,
    val orderStatus: OrderStatus = OrderStatus.NEW,
    val startTime: LocalDateTime = LocalDateTime.now(),
    val endTime: LocalDateTime = LocalDateTime.now(),
) : GenericByIdResponse()