package com.event_organizer_core_spring.controller

import com.event_organizer_core_spring.core.dto.request.GenericByIdRequest
import com.event_organizer_core_spring.dto.request.customer.CustomerRequest
import com.event_organizer_core_spring.dto.response.customer.CustomerResponse
import com.event_organizer_core_spring.dto.response.customer.ListCustomerResponse
import com.event_organizer_core_spring.service.CustomerService
import jakarta.validation.Valid
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/customer")
class CustomerController (
    @Autowired
    val customerService: CustomerService
) {
    @PostMapping("/add")
    fun addCustomer(
        @Valid
        @RequestBody
        request: CustomerRequest
    ) : CustomerResponse {
        return customerService.addCustomer(request)
    }

    @PostMapping("/edit")
    fun editCustomer(
        @Valid
        @RequestBody
        request: CustomerRequest
    ) : CustomerResponse {
        return customerService.editCustoemr(request)
    }

    @PostMapping("/getById")
    fun getCustomerById(
        @Valid
        @RequestBody
        request: GenericByIdRequest
    ) : CustomerResponse {
        return customerService.getCustoemrById(request)
    }

    @PostMapping("/getAll")
    fun getAllCustomer() : ListCustomerResponse {
        return ListCustomerResponse(
            listCustomerResponse = customerService.getAllCustomer()
        )
    }
}