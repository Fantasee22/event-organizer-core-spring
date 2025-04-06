//package com.event_organizer_core_spring.core.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.data.repository.CrudRepository

interface GenericRepository<T, ID> : JpaRepository<T, ID> {
    @Query("SELECT e FROM #{#entityName} e WHERE :condition")
    fun getWhereCond(@Param("condition") condition: String): List<T>
}
