package com.ciaemon.niicdb.models

import javax.persistence.*

@Entity(name = "persons")
class Person(
        @Id @GeneratedValue var id: Long = 0,
        var name: String = "Operator",
        var surname: String = "",
        var middleName: String = "",
        @ManyToOne(cascade = [CascadeType.ALL])
        var lab: Lab? = null,
        @Embedded
        var contacts: Contacts = Contacts(),
        @ManyToOne(optional = true)
        var supervisor: Person? = null
)
