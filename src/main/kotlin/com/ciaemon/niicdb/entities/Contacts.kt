package com.ciaemon.niicdb.entities

import javax.persistence.Embeddable

@Embeddable
class Contacts(
        var phone: String? = null,
        var room: String? = null,
        var roomPhone: String? = null
)
