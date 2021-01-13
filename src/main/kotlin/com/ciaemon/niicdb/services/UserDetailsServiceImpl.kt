package com.ciaemon.niicdb.services

import com.ciaemon.niicdb.repos.UserRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class UserDetailsServiceImpl(@Autowired val userRepo: UserRepo) : UserDetailsService {
    override fun loadUserByUsername(username: String?): UserDetails {
        val user = userRepo.findUserByUsername(username)
            ?: throw UsernameNotFoundException("User $username not found!");
        println("Found user $username")
        val grantList: List<GrantedAuthority> = user.roles.map { SimpleGrantedAuthority(it.name) }
        return User(username, user.password, grantList)
    }
}