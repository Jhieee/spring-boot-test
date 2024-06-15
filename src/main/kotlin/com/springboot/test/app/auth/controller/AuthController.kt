package com.springboot.test.app.auth.controller

import com.springboot.test.app.auth.dto.LoginDto
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("api/v1/users")
@Tag(name = "User API", description = "사용자 api")
class AuthController (
) {

    @PostMapping
    @Tag(name  = "User Login API")
    @Operation(summary = "User 로그인 처리", description = "유저의 로그인 처리를 한다..")
    fun postLogin(
        @RequestBody
        loginDto: LoginDto
    ): Boolean {
        return true
    }
}