package com.event_organizer_core_spring.model.entity

import com.event_organizer_core_spring.constant.OrderStatus
import com.event_organizer_core_spring.model.Order
import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "order_main")
class OrderEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    val id: Long,

    @Column(name = "order_no", nullable = false, unique = true)
    val orderNo: String,

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "service_id", nullable = false, unique = false)
    val service: ServiceEntity,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false, unique = false)
    val customer: CustomerEntity,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pic_id", nullable = false, unique = false)
    val pic: EmployeeEntity,

    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY)
    val payments: List<PaymentEntity> = listOf(),

    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY)
    val orderRequests: List<OrderRequestEntity> = listOf(),

    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY)
    val orderedProperties: List<OrderedPropertyEntity> = listOf()
) {
    constructor() : this (
        id = 0L,
        orderNo = "",
        totalPrice = 0.0,
        totalPaid = 0.0,
        orderStatus = OrderStatus.NEW,
        startTime = LocalDateTime.now(),
        endTime = LocalDateTime.now(),
        service = ServiceEntity(),
        customer = CustomerEntity(),
        pic = EmployeeEntity(),
        payments = listOf(),
        orderRequests = listOf(),
        orderedProperties = listOf()
    )
}

fun OrderEntity.toModel(): Order {
    return Order (
        this.id,
        this.orderNo,
        this.totalPrice,
        this.totalPaid,
        this.orderStatus,
        this.startTime,
        this.endTime,
        this.service,
        this.customer,
        this.pic
    )
}

fun OrderEntity.toModelWithProp(): Order {
    return Order (
        this.id,
        this.orderNo,
        this.totalPrice,
        this.totalPaid,
        this.orderStatus,
        this.startTime,
        this.endTime,
        this.service,
        this.customer,
        this.pic,
//        this.payments.map { it.toModel }, //TODO: after dev toModel Method
//        this.orderRequests,
//        this.orderedProperties
    )
}
