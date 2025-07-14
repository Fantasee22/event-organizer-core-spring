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
    val id: Long,

    @Column(name = "transaction_no", nullable = false, unique = true)
    val transactionNo: String,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", nullable = false, unique = false)
    val order: OrderEntity,

    @Column(name = "installment_price", nullable = false, unique = false)
    val installmentPrice: Double,

    @Column(name = "paid_price", nullable = false, unique = false)
    val paidPrice: Double,

    @Column(name = "pay_datetime", nullable = false, unique = false)
    val payDatetime: LocalDateTime,

    @Column(name = "due_date", nullable = false, unique = false)
    val dueDate: LocalDateTime,

    @Enumerated(EnumType.STRING)
    @Column(name = "payment_method", nullable = false, unique = false)
    val paymentMethod: PaymentMethod,
)