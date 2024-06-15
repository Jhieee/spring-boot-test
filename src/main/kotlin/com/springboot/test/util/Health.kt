package com.springboot.test.util

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("ping")
@Tag(name = "Health check", description = "헬스 체크 ")
class Health {
    @GetMapping
    @Tag(name  = "User API")
    @Operation(summary = "User 조회", description = "유저 정보를 전체 조화한다.")
    fun getApiPing(): String {
        test()

        return "pong"
    }
}

