package com.event_organizer_core_spring.generic

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

abstract class GenericController<T : Any, ID : Any>(private val service: GenericService<T, ID>) {

    @GetMapping
    fun findAll(): List<T> = service.findAll()

    @GetMapping("/{id}")
    fun findById(@PathVariable id: ID): ResponseEntity<T> {
        return service.findById(id)
            ?.let { ResponseEntity.ok(it) }
            ?: ResponseEntity.notFound().build()
    }

    @PostMapping
    fun create(@RequestBody entity: T): T = service.save(entity)

    @PutMapping("/{id}")
    fun update(@PathVariable id: ID, @RequestBody entity: T): T = service.save(entity)

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: ID): ResponseEntity<Unit> {
        service.deleteById(id)
        return ResponseEntity.noContent().build()
    }
}