package com.event_organizer_core_spring.service.impl

import com.event_organizer_core_spring.core.dto.request.GenericByIdRequest
import com.event_organizer_core_spring.dao.CustomerDao
import com.event_organizer_core_spring.dto.request.customer.CustomerRequest
import com.event_organizer_core_spring.dto.response.ServiceResponse
import com.event_organizer_core_spring.dto.response.customer.CustomerResponse
import com.event_organizer_core_spring.dto.response.customer.ListCustomerResponse
import com.event_organizer_core_spring.model.Customer
import com.event_organizer_core_spring.model.Order
import com.event_organizer_core_spring.model.entity.CustomerEntity
import com.event_organizer_core_spring.model.entity.toModel
import com.event_organizer_core_spring.model.toEntity
import com.event_organizer_core_spring.service.CustomerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CustomerServiceImpl (
    @Autowired
    val customerDao: CustomerDao
) : CustomerService
{
    override fun addCustomer(customerRequest: CustomerRequest): CustomerResponse {
        val customer = Customer(
            customerNo = customerRequest.customerNo,
            customerName = customerRequest.customerName,
            phoneNumber = customerRequest.phoneNumber,
            address = customerRequest.address,
            idNo = customerRequest.idNo,
            birthDate = customerRequest.birthDate,
            email = customerRequest.email,
            orders = mutableListOf()
        )

        val addCustomer = customerDao.addCustomer(customer.toEntity()).toModel()

        return CustomerResponse(
            id = addCustomer.id,
            customerNo = addCustomer.customerNo,
            customerName = addCustomer.customerName
        )
    }

    override fun editCustoemr(customerRequest: CustomerRequest): CustomerResponse {
        val customer = Customer(
            id = customerRequest.id,
            customerNo = customerRequest.customerNo,
            customerName = customerRequest.customerName,
            phoneNumber = customerRequest.phoneNumber,
            address = customerRequest.address,
            idNo = customerRequest.idNo,
            birthDate = customerRequest.birthDate,
            email = customerRequest.email,
            orders = mutableListOf()
        )

        val editCustomer = customerDao.editCustomer(customer.toEntity()).toModel()

        return CustomerResponse(
            id = editCustomer.id,
            customerNo = editCustomer.customerNo,
            customerName = editCustomer.customerName
        )
    }

    override fun getCustoemrById(genericByIdRequest: GenericByIdRequest): CustomerResponse {
        val customerObj = customerDao.findCustomerById(genericByIdRequest.id ?: 0)
        if (customerObj != null) {
            return CustomerResponse (
                id = customerObj.id,
                customerNo = customerObj.customerNo,
                customerName = customerObj.customerName,
                phoneNumber = customerObj.phoneNumber,
                address = customerObj.address,
                idNo = customerObj.idNo,
                birthDate = customerObj.birthDate,
                email = customerObj.email
            )
        }

        return CustomerResponse(id = 0)
    }

    override fun getAllCustomer(): List<CustomerResponse> {
        val listOfCustomer : List<CustomerEntity> = customerDao.getAllCustomer()

        val listCustomerRes : List<CustomerResponse> = listOfCustomer.map { customerObj ->
            CustomerResponse(
                id = customerObj.id,
                customerNo = customerObj.customerNo,
                customerName = customerObj.customerName,
                phoneNumber = customerObj.phoneNumber,
                address = customerObj.address,
                idNo = customerObj.idNo,
                birthDate = customerObj.birthDate,
                email = customerObj.email
            )
        }

        return listCustomerRes
    }
}