package com.event_organizer_core_spring.dto.request.order

import com.event_organizer_core_spring.constant.OrderStatus
import com.event_organizer_core_spring.core.dto.request.GenericByIdRequest
import jakarta.validation.constraints.Max
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.PositiveOrZero
import java.time.LocalDateTime

class OrderRequest (
    override val id: Long? = null,

    @NotEmpty
    @Max(value = 50, message = "orderNo max length is 50")
    val orderNo: String,

    @NotEmpty
    @PositiveOrZero
    val totalPrice: Double,

    @NotEmpty
    @PositiveOrZero
    val totalPaid: Double,

    @NotEmpty
    val orderStatus: OrderStatus,

    @NotEmpty
    val startTime: LocalDateTime,

    @NotEmpty
    val endTime: LocalDateTime
) : GenericByIdRequest()