package com.ciaemon.niicdb.repos

import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.NoRepositoryBean

@NoRepositoryBean
interface BaseRepo<T> : CrudRepository<T, Long>