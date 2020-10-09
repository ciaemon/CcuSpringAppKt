package com.ciaemon.niicdb.models

import javax.persistence.*

@Entity(name = "tasks")
class Task(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Long,
        @ManyToOne
        var preparation: User,
        @ManyToOne
        var microscopy: User,
        @ManyToOne
        var photoShot: User,
        @ManyToOne
        var preExp: User,
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
)