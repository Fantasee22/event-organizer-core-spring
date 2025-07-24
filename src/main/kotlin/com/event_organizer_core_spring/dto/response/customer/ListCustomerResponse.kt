package com.event_organizer_core_spring.dto.response.customer

import com.event_organizer_core_spring.core.dto.response.BaseResponse

class ListCustomerResponse (
    var listCustomerResponse: List<CustomerResponse> = listOf()
) : BaseResponse() {
}