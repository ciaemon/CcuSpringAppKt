package com.ciaemon.niicdb.controllers

import com.ciaemon.niicdb.entities.User
import com.ciaemon.niicdb.repos.UserRepo
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/rest")
@Transactional
class RestController(val userRepo: UserRepo) {

    @GetMapping
    fun users(): MutableIterable<User> = userRepo.findAll()
}