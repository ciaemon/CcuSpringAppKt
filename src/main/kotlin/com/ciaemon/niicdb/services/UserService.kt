package com.ciaemon.niicdb.services

import com.ciaemon.niicdb.entities.Role
import com.ciaemon.niicdb.entities.User
import com.ciaemon.niicdb.models.Credentials
import com.ciaemon.niicdb.repos.UserRepo
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class UserService(val userRepo: UserRepo, val passwordEncoder: PasswordEncoder) {
    fun createNew(credentials: Credentials) =
        if (!userRepo.existsByUsername(credentials.username)) {
            val newUser = User(credentials.username, passwordEncoder.encode(credentials.password), null, setOf(Role.USER))
            userRepo.save(newUser)
            println("User with name ${newUser.username} created!")
            true
        } else {
            println("Creation of user failed!")
            false
        }

}