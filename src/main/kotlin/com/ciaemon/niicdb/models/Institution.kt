package com.ciaemon.niicdb.models

import javax.persistence.Entity

@Entity(name = "institutions")
class Institution(
        var name: String = "NIIC"
) : AbstractEntity()