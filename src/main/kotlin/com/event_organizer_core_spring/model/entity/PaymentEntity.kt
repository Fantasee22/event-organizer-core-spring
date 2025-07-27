package com.event_organizer_core_spring.model.entity

import com.event_organizer_core_spring.constant.OrderStatus
import com.event_organizer_core_spring.constant.PaymentMethod
import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "payment")
class PaymentEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id: Long,

    @Column(name = "transaction_no", nullable = false, unique = true)
    var transactionNo: String,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", nullable = false, unique = false)
    var order: OrderEntity,

    @Column(name = "installment_price", nullable = false, unique = false)
    var installmentPrice: Double,

    @Column(name = "paid_price", nullable = false, unique = false)
    var paidPrice: Double,

    @Column(name = "pay_datetime", nullable = false, unique = false)
    var payDatetime: LocalDateTime,

    @Column(name = "due_date", nullable = false, unique = false)
    var dueDate: LocalDateTime,

    @Enumerated(EnumType.STRING)
    @Column(name = "payment_method", nullable = false, unique = false)
    var paymentMethod: PaymentMethod,
)