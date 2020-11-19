package com.ciaemon.niicdb.models

import javax.persistence.Entity
import javax.persistence.JoinColumn
import javax.persistence.OneToOne

@Entity(name = "users")
class User(
        var login: String = "",
        var password: String = "",
        @OneToOne
        @JoinColumn(name = "person_id")
        var person: Person,
) : AbstractEntity()