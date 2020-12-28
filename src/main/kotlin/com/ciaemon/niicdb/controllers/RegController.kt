package com.ciaemon.niicdb.controllers

import com.ciaemon.niicdb.models.Role
import com.ciaemon.niicdb.models.User
import com.ciaemon.niicdb.repos.UserRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/registration")
class RegController(@Autowired val userRepo: UserRepo) {
    @GetMapping
    fun regPage(@ModelAttribute("user") user: User): String = "registration"
    @PostMapping
    fun newUser(@ModelAttribute("user") newUser: User): String {
        newUser.role = Role.USER
        userRepo.save(newUser)
        return "redirect:/"
    }
}