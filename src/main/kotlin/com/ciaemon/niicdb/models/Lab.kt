package com.ciaemon.niicdb.models

import javax.persistence.*

@Entity(name = "labs")
class Lab(
        @Id
        @GeneratedValue
        var id: Long,
        var name: String,
        var number: Int,
        @ManyToOne
        var institution: Institution,
        @OneToOne(optional = false)
        var head: Person
)