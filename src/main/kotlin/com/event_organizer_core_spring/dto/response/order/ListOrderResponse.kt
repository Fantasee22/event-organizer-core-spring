package com.event_organizer_core_spring.dto.response.order

import com.event_organizer_core_spring.core.dto.response.BaseResponse

class ListOrderResponse (
    val listOrderResponse : List<OrderResponse> = listOf()
) : BaseResponse() {
}