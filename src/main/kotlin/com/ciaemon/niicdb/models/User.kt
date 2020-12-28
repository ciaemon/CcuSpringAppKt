package com.ciaemon.niicdb.models

import javax.persistence.*

@Entity(name = "users")
class User(
        var username: String?,
        var password_encoded: String?,
        @OneToOne(fetch = FetchType.LAZY, optional = true)
        @JoinColumn(name = "person_id")
        var person: Person?,
        @Enumerated(value = EnumType.STRING)
        var role: Role?,
        @Transient var isActive: Boolean = false
) : AbstractEntity()

enum class Role {
        ADMIN,
        USER,
        SUPERVISOR,
        CRYSTALLOGRAPHER
}