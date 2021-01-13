package com.ciaemon.niicdb.entities

import javax.persistence.Entity
import javax.persistence.ManyToOne

@Entity(name = "tasks")
class Task(
        @ManyToOne
        var preparation: User? = null,
        @ManyToOne
        var microscopy: User? = null,
        @ManyToOne
        var photoShot: User? = null,
        @ManyToOne
        var preExp: User? = null,
        var preExpTemp: Int = 150,
        @ManyToOne
        var diffDescription: User,
        @ManyToOne
        var strategy: User,
        @ManyToOne
        var experiment: User,
        var experimentTemp: Int = 150,
        @ManyToOne
        var reduction: User,
        @ManyToOne
        var solution: User,
        @ManyToOne
        var deposition: User,
        var needToStore: Boolean
) : AbstractEntity()