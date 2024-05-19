package com.springboot.test.app.users.controllers

import com.springboot.test.core.db.entity.Users
import com.springboot.test.core.db.repository.UsersRepository
import com.springboot.test.utils.response.ResponseEntity
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/v1/users")
@Tag(name = "User API", description = "사용자 api")
class UsersController(
    private val usersRepository: UsersRepository
) {

    @GetMapping
    @Tag(name  = "User API")
    @Operation(summary = "User 조회", description = "유저 정보를 전체 조화한다.")
    fun getUsers(): ResponseEntity<List<Users>> {
        val userList = usersRepository.findAllBy()
        return ResponseEntity(data=userList)
    }
}