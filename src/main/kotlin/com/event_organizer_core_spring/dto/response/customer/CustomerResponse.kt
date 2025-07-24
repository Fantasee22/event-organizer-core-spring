package com.event_organizer_core_spring.dto.response.customer

import com.event_organizer_core_spring.core.dto.response.GenericByIdResponse
import java.time.LocalDateTime

class CustomerResponse (
    override val id: Long? = null,

    var customerNo: String = "",

    var customerName: String = "",

    var phoneNumber: String = "",

    var address: String = "",

    var idNo: String? = "",

    var birthDate: LocalDateTime? = null,

    var email: String = ""
) : GenericByIdResponse()