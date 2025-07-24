package com.event_organizer_core_spring.dto.request.customer

import com.event_organizer_core_spring.core.dto.request.GenericByIdRequest
import jakarta.validation.constraints.NotEmpty
import java.time.LocalDateTime

class CustomerRequest (
    override val id: Long? = null,

    @NotEmpty
    var customerNo: String,

    @NotEmpty
    var customerName: String,

    @NotEmpty
    var phoneNumber: String,

    @NotEmpty
    var address: String,

    var idNo: String?,

    var birthDate: LocalDateTime?,

    @NotEmpty
    var email: String,

    ) : GenericByIdRequest()
