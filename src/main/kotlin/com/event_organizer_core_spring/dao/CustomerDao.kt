package com.event_organizer_core_spring.dao;

import com.event_organizer_core_spring.model.entity.CustomerEntity;

public interface CustomerDao {
    fun addCustomer(customerEntity: CustomerEntity): CustomerEntity
    fun editCustomer(customerEntity: CustomerEntity): CustomerEntity
    fun findCustomerById(id: Long): CustomerEntity
    fun findCustomerById(id: Long, useException: Boolean): CustomerEntity?
    fun getAllCustomer(): List<CustomerEntity>
}
