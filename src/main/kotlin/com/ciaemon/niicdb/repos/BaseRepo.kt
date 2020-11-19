package com.ciaemon.niicdb.repos

import org.springframework.data.repository.CrudRepository

interface BaseRepo<T> : CrudRepository<T, Long> {
}