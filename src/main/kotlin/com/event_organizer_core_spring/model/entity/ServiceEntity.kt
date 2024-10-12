package com.event_organizer_core_spring.model.entity

import jakarta.persistence.*

@Entity
@Table(name = "service")
class ServiceEntity (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    val id: Long,

    @Column(name = "service_code", nullable = false, unique = true, length = 50)
    val serviceCode: String,

    @Column(name = "service_name", nullable = false, unique = false, length = 50)
    val serviceName: String,

    @Column(name = "service_type", nullable = false, unique = false, length = 20)
    val serviceType: String,

    @Column(name = "description", nullable = false, unique = false, length = 2000)
    val description: String,

    @Column(name = "minimum_price", nullable = false, unique = false)
    val minimumPrice: Double,

    @Column(name = "maximal_price", nullable = false, unique = false)
    val maximalPrice: Double,

    @Column(name = "estimation_time", nullable = false, unique = false)
    val estimationTime: Float,

    @Column(name = "terms_and_condition", nullable = false, unique = false, length = 2000)
    val termsAndCondition: String,

    @OneToMany(cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    @JoinColumn(name = "service_id")
    val images: List<ServiceImageEntity> = listOf(),

    @ElementCollection(fetch = FetchType.LAZY)
    @Column(name = "mapping_service_properties", nullable = false)
    val mappingServiceProperties: List<String>,

    @OneToMany(mappedBy = "service", fetch = FetchType.LAZY)
    val orders: List<OrderEntity> = listOf()
)