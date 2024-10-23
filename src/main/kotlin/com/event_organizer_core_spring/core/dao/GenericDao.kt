package com.event_organizer_core_spring.core.dao

interface GenericDao<T, ID> {
    fun save(entity: T): T
    fun findById(id: ID): T?
    fun delete(entity: T)
    fun findAll(): List<T>
}