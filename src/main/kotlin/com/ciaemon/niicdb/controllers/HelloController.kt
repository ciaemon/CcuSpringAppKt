package com.ciaemon.niicdb.controllers

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class HelloController {
    @GetMapping
    fun helloPage(): String = "hello"



}