package com.event_organizer_core_spring.service

import com.event_organizer_core_spring.core.dto.request.GenericByIdRequest
import com.event_organizer_core_spring.dto.request.customer.CustomerRequest
import com.event_organizer_core_spring.dto.response.customer.CustomerResponse
import com.event_organizer_core_spring.dto.response.order.OrderResponse
import com.event_organizer_core_spring.generic.GenericService
import com.event_organizer_core_spring.model.entity.CustomerEntity

interface CustomerService : GenericService<CustomerEntity, Long> {
    fun addCustomer(customerRequest: CustomerRequest) : CustomerResponse
    fun editCustoemr(customerRequest: CustomerRequest) : CustomerResponse
    fun getCustoemrById (genericByIdRequest: GenericByIdRequest) : CustomerResponse
    fun getAllCustomer() : List<CustomerResponse>
}