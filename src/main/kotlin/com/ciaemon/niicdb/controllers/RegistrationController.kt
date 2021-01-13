package com.ciaemon.niicdb.controllers

import com.ciaemon.niicdb.models.Credentials
import com.ciaemon.niicdb.services.UserService
import org.springframework.stereotype.Controller
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import javax.validation.Valid


@Controller
@RequestMapping("/registration")
class RegistrationController(val userService: UserService) {

    @GetMapping
    fun regPage(@ModelAttribute("cred") credentials: Credentials): String = "registration"

    @PostMapping
    fun newUser(@ModelAttribute("cred") @Valid credentials: Credentials, bindingResult: BindingResult): String =
        if (userService.createNew(credentials))
            "redirect:/"
        else
            "redirect:/registration"
}