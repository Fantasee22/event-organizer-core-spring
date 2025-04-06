//package com.event_organizer_core_spring.core.controller

//import com.event_organizer_core_spring.core.repository.GenericRepository
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/{entityName}")
class GenericController<T, ID>(
    private val repository: GenericRepository<T, ID>
) where T : Any, ID : Any {
    @GetMapping("/{id}")
    fun getById(@PathVariable id: ID): T? = repository.findById(id).orElse(null)

    @GetMapping
    fun getAll(): List<T> = repository.findAll()

    @PostMapping
    fun create(@RequestBody entity: T): T = repository.save(entity)

    @PutMapping("/{id}")
    fun update(@PathVariable id: ID, @RequestBody entity: T): T = repository.save(entity)

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: ID) = repository.deleteById(id)

    // **JPQL Dynamic Query**
    @GetMapping("/filter")
    fun getWhereCond(
        @RequestParam tableName: String,
        @RequestParam condition: String
    ): List<T> {
        return repository.getWhereCond(condition)
    }
}