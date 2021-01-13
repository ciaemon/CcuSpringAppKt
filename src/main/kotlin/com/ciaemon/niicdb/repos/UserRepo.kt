package com.ciaemon.niicdb.repos

import com.ciaemon.niicdb.entities.User

interface UserRepo : BaseRepo<User> {
   fun findUserByUsername(username: String?): User?
   fun existsByUsername(username: String): Boolean
}