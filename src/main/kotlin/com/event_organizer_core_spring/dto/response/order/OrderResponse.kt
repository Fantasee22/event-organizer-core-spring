package com.event_organizer_core_spring.dto.response.order

import com.event_organizer_core_spring.constant.OrderStatus
import com.event_organizer_core_spring.core.dto.response.GenericByIdResponse
import java.time.LocalDateTime

class OrderResponse (
    override val id: Long? = null,
    val orderNo: String,
    val totalPrice: Double,
    val totalPaid: Double,
    val orderStatus: OrderStatus,
    val startTime: LocalDateTime,
    val endTime: LocalDateTime,
) : GenericByIdResponse()