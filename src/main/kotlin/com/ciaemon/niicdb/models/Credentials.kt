package com.ciaemon.niicdb.models

import javax.validation.constraints.Email

data class Credentials(@Email val username: String = "", val password: String = "", val passwordPrompt: String = "") {
    fun isValid() = password == passwordPrompt
}