package com.ciaemon.niicdb.models

import javax.persistence.*

@Entity(name = "samples")
class Sample(
        var color: String,
        var shape: String,
        var sizeX: String,
        var sizeY: String,
        var sizeZ: String,
        @OneToOne
        var cell: Cell
) : AbstractEntity()