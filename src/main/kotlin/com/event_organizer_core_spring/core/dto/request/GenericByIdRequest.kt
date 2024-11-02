package com.event_organizer_core_spring.core.dto.request

open class GenericByIdRequest(
    open val id: Long? = null
) : BaseRequest()