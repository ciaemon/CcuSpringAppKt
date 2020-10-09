package com.ciaemon.niicdb.models

import javax.persistence.*

@Entity(name = "samples")
class Sample(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Long,
        var color: String,
        var shape: String,
        var sizeX: String,
        var sizeY: String,
        var sizeZ: String,
        @OneToOne
        var cell: Cell
)