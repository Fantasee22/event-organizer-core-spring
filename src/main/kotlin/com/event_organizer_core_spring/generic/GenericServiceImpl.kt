package com.event_organizer_core_spring.generic

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.findByIdOrNull
import kotlin.reflect.full.memberProperties
import kotlin.reflect.KMutableProperty1
import kotlin.reflect.full.primaryConstructor
import kotlin.reflect.jvm.isAccessible
import kotlin.reflect.jvm.jvmErasure

open class GenericServiceImpl<T : Any, ID: Any>(
    private val repository: JpaRepository<T, ID>
) : GenericService<T, ID> {

    override fun findAll(): List<T> = repository.findAll()

    override fun findById(id: ID): T? = repository.findByIdOrNull(id)

    override fun save(entity: T): T = repository.save(entity)

    override fun deleteById(id: ID) = repository.deleteById(id)

    override fun update(id: ID, entity: T): T {
        var existing = repository.findById(id).orElseThrow()
        updateEntity(existing, entity)
        return repository.save(existing)
    }

    //NOTES: This method use reflection, so it may be slow performance wise
    private fun updateEntity(existing: T, updated: T): T {
        var kClass = existing::class

        for (prop in kClass.memberProperties) {
//            if (prop.annotations.any { it.annotationClass.simpleName == "Id" }) continue // skip id
            if (prop.name == "id") continue // safer skip for ID
            if (prop.returnType.jvmErasure == List::class) continue  // Skip list properties
            if (prop.returnType.jvmErasure == MutableList::class) continue  // Skip mutable list properties
            if (prop !is KMutableProperty1) continue  // Skip read-only properties

            @Suppress("UNCHECKED_CAST")
            var mutableProp = prop as KMutableProperty1<T, Any?>

            mutableProp.isAccessible = true
            var newValue = mutableProp.get(updated)
            if (newValue != null) {
                println("Updating ${prop.name} from ${mutableProp.get(existing)} to $newValue")
                mutableProp.set(existing, newValue)
            }
        }

        return existing
    }
}