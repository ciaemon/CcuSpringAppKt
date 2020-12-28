package com.ciaemon.niicdb.repos

import com.ciaemon.niicdb.models.User

interface UserRepo : BaseRepo<User> {
   fun findUserByUsername(username: String?): User?
}