package com.ciaemon.niicdb.models

import java.util.*
import javax.persistence.*

@Entity
class Experiment(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Long,
        @Temporal(TemporalType.TIMESTAMP)
        var startTime: Date,
        @Temporal(TemporalType.TIMESTAMP)
        var endTime: Date,
        @ManyToOne
        var sample: Sample,
        @ManyToOne
        var cell: Cell,
        var resolutionMin: Double,
        @Enumerated(EnumType.STRING)
        var diffractionType: DiffractionType,
        var framesNumber: Int,
        var storage: String,

) {
        fun duration(): Int = ((endTime.time - startTime.time) / 3_600_000).toInt()
}

enum class DiffractionType(code: Int, description: String) {
        UNINDEFINED (0, "что-то странное, не классифицируется"),
        POWDER(1, "порошок (дифракционные кольца)"),
        POLYCRYSTAL(2, "поликристалл (отдельные пики, образующие кольца, >4 доменов)"),
        OLYGOCRYSTALL(3, "олигокристалл (2-4 домена)"),
        MODULATED_CRYSTAL(4, "модулированная структура (сателлиты у основных пиков)"),
        HIGH_DUFFUSE_SCATTERING(5, "монокристалл с сильным диффузным рассеянием"),
        DECOMPOSED_CRYSTAL(6, "деформированный/разложившийся кристалл или образец с градиентом состава (размазанные, много модальные пики)"),
        TEXTURED_POWDER(7, "текстурированный порошок (дифракционные дуги)"),
        MONOCRYSTAL_LOWQ(8, "грязный кристалл (один основной и несколько примесных доменов)"),
        MONOCRYSTAL(9, "монокристалл")
}