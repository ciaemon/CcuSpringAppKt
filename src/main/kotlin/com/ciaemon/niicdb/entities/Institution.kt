package com.ciaemon.niicdb.entities

import javax.persistence.Entity

@Entity(name = "institutions")
class Institution(
        var name: String = "NIIC"
) : AbstractEntity()