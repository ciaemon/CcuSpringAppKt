package com.ciaemon.niicdb.models

import javax.persistence.Column
import javax.persistence.Embeddable

@Embeddable
class Contacts(
        @Column(unique = true) var email: String = "",
        var phone: String? = null,
        var room: String? = null,
        var roomPhone: String? = null
)
