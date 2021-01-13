package com.ciaemon.niicdb.entities

import org.springframework.data.util.ProxyUtils
import javax.persistence.*

@MappedSuperclass
abstract class AbstractEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
    @Column
    var isRemoved = false

    override fun equals(other: Any?): Boolean {
        other ?: return false

        if (this === other) return true

        if (javaClass != ProxyUtils.getUserClass(other)) return false

        other as AbstractEntity

        return this.id != null && this.id == other.id

    }

    override fun hashCode() = 300
}
