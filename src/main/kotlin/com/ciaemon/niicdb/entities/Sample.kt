package com.ciaemon.niicdb.entities

import javax.persistence.Entity
import javax.persistence.OneToOne
import javax.validation.constraints.Positive

@Entity(name = "samples")
class Sample(
        var color: String,
        var shape: String,
        @Positive var sizeX: String,
        @Positive var sizeY: String,
        @Positive var sizeZ: String,
        @OneToOne
        var cell: Cell
) : AbstractEntity()