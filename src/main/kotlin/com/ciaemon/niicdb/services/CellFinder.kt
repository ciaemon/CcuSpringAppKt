package com.ciaemon.niicdb.services

import com.ciaemon.niicdb.repos.CellRepo
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class CellFinder(private val repo: CellRepo) {

}