package com.ciaemon.niicdb.models

import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.pow
import kotlin.math.sqrt


@Entity(name = "cells")
class Cell(
        @Enumerated(EnumType.STRING) var crystalSystem: CrystalSystem,
        var a: Double = 0.0,
        var b: Double = 0.0,
        var c: Double = 0.0,
        var alpha: Double = 90.0,
        var beta: Double = 90.0,
        var gamma: Double = 90.0,
) : AbstractEntity() {

    private fun Double.toRad(): Double = this * PI / 180
    val volume: Double
        get() = a * b * c * sqrt(
                1 - cos(alpha.toRad()).pow(2) - cos(beta.toRad()).pow(2) - cos(gamma.toRad()).pow(2)
                        + 2 * cos(alpha.toRad()) * cos(beta.toRad()) * cos(gamma.toRad())
        )
}

enum class CrystalSystem {
    TRICLINIC,
    MONOCLINIC,
    ORTHORHOMBIC,
    TETRAGONAL,
    TRIGONAL,
    CUBIC
}
