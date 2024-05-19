package com.springboot.test.core.db.repository

import com.springboot.test.core.db.entity.Users
import org.springframework.data.jpa.repository.JpaRepository

interface UsersRepository: JpaRepository<Users, Long> {
    fun findAllBy(): List<Users>
    fun findByUserName(userName: String): Users
}