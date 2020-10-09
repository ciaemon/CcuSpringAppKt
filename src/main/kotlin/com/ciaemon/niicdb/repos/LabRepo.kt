package com.ciaemon.niicdb.repos

import com.ciaemon.niicdb.models.Lab
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface LabRepo : CrudRepository<Lab, Long> {

}