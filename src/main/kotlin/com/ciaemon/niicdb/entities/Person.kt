package com.ciaemon.niicdb.entities

import javax.persistence.*

@Entity(name = "persons")
class Person(
        var name: String = "Operator",
        var surname: String = "",
        var middleName: String = "",
        @ManyToOne(cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
        var lab: Lab? = null,
        @Embedded
        var contacts: Contacts = Contacts(),
        @ManyToOne(optional = true, fetch = FetchType.LAZY)
        var supervisor: Person? = null
) : AbstractEntity()
