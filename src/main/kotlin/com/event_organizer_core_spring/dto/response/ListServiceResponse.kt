package com.event_organizer_core_spring.dto.response

import com.event_organizer_core_spring.core.dto.response.BaseResponse

data class ListServiceResponse (
    val listServiceResponse : List<ServiceResponse> = listOf()
) : BaseResponse() {}