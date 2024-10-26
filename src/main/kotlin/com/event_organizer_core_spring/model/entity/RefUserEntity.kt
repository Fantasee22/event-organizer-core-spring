package com.event_organizer_core_spring.model.entity

import com.event_organizer_core_spring.model.RefUser
import jakarta.persistence.*

@Entity
@Table(name = "ref_user")
class RefUserEntity (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    val id: Long? = null,

    @Column(name = "user_name", nullable = false, unique = true, length = 100)
    val userName: String,

    @Column(name = "password", nullable = false, length = 100)
    val password: String,

    @Column(name = "is_locked", nullable = false)
    val isLocked: Boolean,

    @Column(name = "is_active", nullable = false)
    val isActive: Boolean,

    @Column(name = "role_code", nullable = false, length = 50)
    val roleCode: String,

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id", nullable = true)
    var employee: EmployeeEntity? = null,

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = true)
    var customer: CustomerEntity? = null
)

fun RefUserEntity.toModel(): RefUser {
    return RefUser(
        this.id,
        this.userName,
        this.password,
        this.isLocked,
        this.isActive,
        this.roleCode
    )
}