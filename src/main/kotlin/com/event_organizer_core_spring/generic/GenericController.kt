package com.event_organizer_core_spring.generic

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

abstract class GenericController<T : Any, ID : Any>(private val service: GenericService<T, ID>) {

    @GetMapping("/generic/findAll")
    fun findAll(): List<T> = service.findAll()

    @GetMapping("/generic/find/{id}")
    fun findById(@PathVariable id: ID): ResponseEntity<T> {
        return service.findById(id)
            ?.let { ResponseEntity.ok(it) }
            ?: ResponseEntity.notFound().build()
    }

    @PostMapping("/generic/create")
    fun create(@RequestBody entity: T): T = service.save(entity)

    @PutMapping("/generic/update/{id}")
    fun update(@PathVariable id: ID, @RequestBody entity: T): T = service.update(id, entity)

    @DeleteMapping("/generic/delete/{id}")
    fun delete(@PathVariable id: ID): ResponseEntity<Unit> {
        service.deleteById(id)
        return ResponseEntity.noContent().build()
    }
}