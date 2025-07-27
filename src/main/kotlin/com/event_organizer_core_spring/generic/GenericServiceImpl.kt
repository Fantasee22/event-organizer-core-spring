package com.event_organizer_core_spring.generic

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.findByIdOrNull

open class GenericServiceImpl<T : Any, ID: Any>(
    private val repository: JpaRepository<T, ID>
) : GenericService<T, ID> {

    override fun findAll(): List<T> = repository.findAll()

    override fun findById(id: ID): T? = repository.findByIdOrNull(id)

    override fun save(entity: T): T = repository.save(entity)

    override fun deleteById(id: ID) = repository.deleteById(id)
}