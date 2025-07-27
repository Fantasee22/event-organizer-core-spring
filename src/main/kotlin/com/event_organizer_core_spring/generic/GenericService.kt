package com.event_organizer_core_spring.generic

interface GenericService<T, ID> {
    fun findAll(): List<T>
    fun findById(id: ID): T?
    fun save(entity: T): T
    fun deleteById(id: ID)
}