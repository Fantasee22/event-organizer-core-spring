package com.event_organizer_core_spring.dao.impl

import com.event_organizer_core_spring.dao.CustomerDao
import com.event_organizer_core_spring.model.entity.CustomerEntity
import com.event_organizer_core_spring.repository.CustomerRepository
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Component
import org.springframework.web.server.ResponseStatusException

@Component
class CustomerDaoImpl (
    val customerRepository: CustomerRepository
) : CustomerDao {
    override fun addCustomer(customerEntity: CustomerEntity): CustomerEntity {
        return customerRepository.save(customerEntity)
    }

    override fun editCustomer(customerEntity: CustomerEntity): CustomerEntity {
        findCustomerById(customerEntity.id ?: 0, useException = true)
        return customerRepository.save(customerEntity)
    }

    override fun findCustomerById(id: Long): CustomerEntity {
        return customerRepository.findById(id).orElseThrow {
            ResponseStatusException(HttpStatus.NOT_FOUND, "Customer not found")
        }
    }

    override fun findCustomerById(id: Long, useException: Boolean): CustomerEntity? {
        if (useException) {
            return customerRepository.findById(id).orElseThrow {
                ResponseStatusException(HttpStatus.NOT_FOUND, "Customer not found")
            }
        }
        return customerRepository.findById(id).orElse(null)
    }

    override fun getAllCustomer(): List<CustomerEntity> {
        TODO("Not yet implemented")
    }

}