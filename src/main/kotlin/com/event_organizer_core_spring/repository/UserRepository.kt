package com.event_organizer_core_spring.repository

import com.event_organizer_core_spring.model.entity.RefUserEntity
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository: JpaRepository<RefUserEntity, Long>