package com.ciaemon.niicdb.models

import javax.persistence.*

@Entity(name = "users")
class User(
        @Id @GeneratedValue
        var id: Long = 0,
        var login: String = "",
        var password: String = "",
        @OneToOne
        @JoinColumn(name = "person_id")
        var person: Person = Person(),
)