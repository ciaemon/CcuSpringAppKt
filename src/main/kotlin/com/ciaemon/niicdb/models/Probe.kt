package com.ciaemon.niicdb.models

import java.util.*
import javax.persistence.*

@Entity (name = "probes")
class Probe(
        @Id
        @GeneratedValue
        var id: Long = 0,
        @Temporal(TemporalType.DATE)
        var reqDate: Date = Date(),
        var cifer: String = "cifer",
        @ManyToOne
        var user_id: User = User(),
        var appearance: String = "appearance",
        var container: String = "container",
        var solvent: String = "solvent",
        var contents: String = "contents",
        @ManyToMany(fetch = FetchType.EAGER, cascade = [CascadeType.PERSIST])
        var knownCells: MutableSet<Cell> = mutableSetOf(),
        @ManyToMany
        var desiredCells: MutableSet<Cell> = mutableSetOf(),
        @Enumerated(EnumType.STRING) var submitType: SubmitType = SubmitType.BEFORE,
        @Enumerated(EnumType.STRING) var storageType: StorageType = StorageType.NO_SPECIAL_CONDITIONS,
        @Enumerated(EnumType.STRING) var presenceType: PresenceType = PresenceType.OPTIONAL,
)

enum class SubmitType {
        BEFORE,
        RIGHT_AWAY
}
enum class StorageType {
        NO_SPECIAL_CONDITIONS,
        FREEZER,
        DARKNESS,
        DRY
}
enum class PresenceType {
        OPTIONAL,
        REQUIRED,
        DESIRABLE
}