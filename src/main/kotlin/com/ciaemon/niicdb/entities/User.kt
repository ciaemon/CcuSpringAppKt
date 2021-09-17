package com.ciaemon.niicdb.entities

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*
import javax.validation.constraints.Email

@Entity(name = "users")
class User(
        @Email
        val username: String = "",
        @JsonIgnore
        var password: String = "",
        @OneToOne(fetch = FetchType.LAZY, optional = true)
        @JoinColumn(name = "person_id")
        var person: Person? = null,
        @ElementCollection(targetClass = Role::class, fetch = FetchType.EAGER)
        @Enumerated(value = EnumType.STRING)
        val roles: Set<Role> = mutableSetOf(Role.USER),
        @Transient var isActive: Boolean = false
) : AbstractEntity()

enum class Role {
        ADMIN,
        CRYSTALLOGRAPHER,
        SUPERVISOR,
        OPERATOR,
        LAB_HEAD,
        USER
}