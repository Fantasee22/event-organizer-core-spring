package com.event_organizer_core_spring.model.entity

import com.event_organizer_core_spring.model.RefUser
import jakarta.persistence.*

@Entity
@Table(name = "ref_user")
class RefUserEntity (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id: Long? = null,

    @Column(name = "user_name", nullable = false, unique = true, length = 100)
    var userName: String,

    @Column(name = "password", nullable = false, length = 100)
    var password: String,

    @Column(name = "is_locked", nullable = false)
    var isLocked: Boolean,

    @Column(name = "is_active", nullable = false)
    var isActive: Boolean,

    @Column(name = "role_code", nullable = false, length = 50)
    var roleCode: String,

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