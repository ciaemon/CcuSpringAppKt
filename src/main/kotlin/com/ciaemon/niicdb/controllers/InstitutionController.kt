package com.ciaemon.niicdb.controllers

import com.ciaemon.niicdb.repos.InstitutionRepo
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/institutions")
class InstitutionController(var institutionRepo: InstitutionRepo) {
    @GetMapping
    fun index(model: Model): String {
        val institutions = institutionRepo.findAll()
        model["index"] = institutions
        return "institutions/index"
    }
}