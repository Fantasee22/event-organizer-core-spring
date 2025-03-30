package com.event_organizer_core_spring

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication

@SpringBootApplication
@EntityScan("com.event_organizer_core_spring.model.entity")
class EventOrganizerCoreSpringApplication

fun main(args: Array<String>) {
	runApplication<EventOrganizerCoreSpringApplication>(*args)
}
