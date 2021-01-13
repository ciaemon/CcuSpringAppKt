package com.ciaemon.niicdb.entities

import javax.persistence.Entity
import javax.persistence.ManyToOne
import javax.persistence.OneToOne

@Entity(name = "labs")
class Lab(
        var name: String,
        var number: Int,
        @ManyToOne
        var institution: Institution,
        @OneToOne(optional = false)
        var head: Person
) : AbstractEntity()