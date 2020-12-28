package com.ciaemon.niicdb.services

import com.ciaemon.niicdb.repos.UserRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserDetailsServiceImpl(@Autowired val userRepo: UserRepo) : UserDetailsService {
    override fun loadUserByUsername(username: String?): UserDetails {
        val user =
            userRepo.findUserByUsername(username) ?: throw UsernameNotFoundException("User $username not found!");
        val role = user.role
        println("Found user $username")
        val grantList = Collections.singleton(SimpleGrantedAuthority(role?.name))
        return User(username, user.password_encoded, grantList)
    }
}