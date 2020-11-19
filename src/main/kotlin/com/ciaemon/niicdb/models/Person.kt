package com.ciaemon.niicdb.models

import javax.persistence.CascadeType
import javax.persistence.Embedded
import javax.persistence.Entity
import javax.persistence.ManyToOne

@Entity(name = "persons")
class Person(
        var name: String = "Operator",
        var surname: String = "",
        var middleName: String = "",
        @ManyToOne(cascade = [CascadeType.ALL])
        var lab: Lab? = null,
        @Embedded
        var contacts: Contacts = Contacts(),
        @ManyToOne(optional = true)
        var supervisor: Person? = null
) : AbstractEntity()
