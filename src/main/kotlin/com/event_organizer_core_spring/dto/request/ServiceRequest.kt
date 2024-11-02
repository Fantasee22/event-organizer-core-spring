package com.event_organizer_core_spring.dto.request

import com.event_organizer_core_spring.core.dto.request.GenericByIdRequest
import jakarta.persistence.Column
import jakarta.validation.constraints.Max
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.PositiveOrZero

data class ServiceRequest (

    @NotEmpty
    @Max(value = 50, message = "serviceCode max length is 50")
    val serviceCode: String = "",

    @NotEmpty
    @Max(value = 100, message = "serviceName max length is 100")
    val serviceName: String = "",

    @NotEmpty
    @Max(value = 100, message = "serviceName max length is 20")
    val serviceType: String = "",

    @NotEmpty
    @Max(value = 2000, message = "description max length is 2000")
    val description: String = "",

    @NotEmpty
    @PositiveOrZero
    val minimumPrice: Double = 0.00,

    @NotEmpty
    @PositiveOrZero
    val maximalPrice: Double = 0.00,

    @NotEmpty
    @PositiveOrZero
    val estimationTime: Float = 0.00f,

    @Column(name = "terms_and_condition", nullable = false, unique = false, length = 2000)
    val termsAndCondition: String = "",

    override val id: Long? = null
) : GenericByIdRequest()