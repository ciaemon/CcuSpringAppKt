package com.ciaemon.niicdb.repos

import com.ciaemon.niicdb.models.Institution
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface InstitutionRepo : CrudRepository<Institution, Long> {
}