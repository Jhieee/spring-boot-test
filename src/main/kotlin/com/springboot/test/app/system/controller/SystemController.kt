package com.springboot.test.app.user.controller

import com.springboot.test.app.system.dto.SystemDto
import com.springboot.test.app.system.service.SystemService
import com.springboot.test.core.db.entity.SystemMetaEntity
import com.springboot.test.util.response.ResponseEntity
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/v1/systems")
@Tag(name = "System API", description = "시스템 api")
class SystemController(
    private val systemService: SystemService
) {
    @GetMapping
    @Operation(summary = "시스템 조회", description = "시스템 정보를 전체 조회한다.")
    fun getSystemAll(): ResponseEntity<List<SystemMetaEntity>?> {
        return ResponseEntity(data = systemService.getSystemAll())
    }

    @PostMapping
    @Operation(summary = "시스템 추가", description = "시스템 정보를 추가한다.")
    fun addSystem(
        @RequestBody
        systemDto: SystemDto
    ): ResponseEntity<SystemMetaEntity>? {
        return ResponseEntity(data = systemService.addSystem(systemDto))
    }
}