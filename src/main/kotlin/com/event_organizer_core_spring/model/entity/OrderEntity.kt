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
    var id: Long,

    @Column(name = "order_no", nullable = false, unique = true)
    var orderNo: String,

    @Column(name = "total_price", nullable = false, unique = false)
    var totalPrice: Double,

    @Column(name = "total_paid", nullable = false, unique = false)
    var totalPaid: Double,

    @Enumerated(EnumType.STRING)
    @Column(name = "order_status", nullable = false, unique = false)
    var orderStatus: OrderStatus,

    @Column(name = "start_time", nullable = false, unique = false)
    var startTime: LocalDateTime,

    @Column(name = "end_time", nullable = false, unique = false)
    var endTime: LocalDateTime,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "service_id", nullable = false, unique = false)
    var service: ServiceEntity,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false, unique = false)
    var customer: CustomerEntity,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pic_id", nullable = false, unique = false)
    var pic: EmployeeEntity,

    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY)
    var payments: MutableList<PaymentEntity> = mutableListOf(),

    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY)
    var orderRequests: MutableList<OrderRequestEntity> = mutableListOf(),

    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY)
    var orderedProperties: MutableList<OrderedPropertyEntity> = mutableListOf()
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
        payments = mutableListOf(),
        orderRequests = mutableListOf(),
        orderedProperties = mutableListOf()
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
