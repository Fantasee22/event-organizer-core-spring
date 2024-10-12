package com.event_organizer_core_spring.model.entity

import com.event_organizer_core_spring.constant.OrderStatus
import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
class OrderEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    val id: Long,

    @Column(name = "order_no", nullable = false, unique = true)
    val orderNo: String,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "service_id", nullable = false, unique = false)
    val service: ServiceEntity,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false, unique = false)
    val customer: CustomerEntity,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pic_id", nullable = false, unique = false)
    val pic: EmployeeEntity,

    @Column(name = "total_price", nullable = false, unique = false)
    val totalPrice: Double,

    @Column(name = "total_paid", nullable = false, unique = false)
    val totalPaid: Double,

    @Enumerated(EnumType.STRING)
    @Column(name = "order_status", nullable = false, unique = false)
    val orderStatus: OrderStatus,

    @Column(name = "start_time", nullable = false, unique = false)
    val startTime: LocalDateTime,

    @Column(name = "end_time", nullable = false, unique = false)
    val endTime: LocalDateTime,

    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY)
    val payments: List<PaymentEntity> = listOf(),
)