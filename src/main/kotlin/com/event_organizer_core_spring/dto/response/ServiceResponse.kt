package com.event_organizer_core_spring.dto.response

import com.event_organizer_core_spring.core.dto.response.GenericByIdResponse

data class ServiceResponse (
    val serviceCode: String = "",
    val serviceName: String = "",
    val serviceType: String = "",
    val description: String = "",
    val minimumPrice: Double = 0.00,
    val maximalPrice: Double = 0.00,
    val estimationTime: Float = 0.00f,
    val termsAndCondition: String = "",
    val isActive: Boolean = false,
    override val id: Long? = null
) : GenericByIdResponse()