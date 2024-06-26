package com.springboot.test.app.user.controller

import com.springboot.test.app.system.dto.SystemDto
import com.springboot.test.app.system.dto.SystemPermissionDto
import com.springboot.test.app.system.dto.SystemPermissionUserDto
import com.springboot.test.app.system.service.SystemService
import com.springboot.test.core.db.entity.SystemMetaEntity
import com.springboot.test.core.db.entity.SystemPermissionEntity
import com.springboot.test.util.response.ResponseEntity
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.*

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

    @GetMapping("{id}")
    @Operation(summary = "시스템 조회", description = "시스템 정보를 조회한다.")
    fun getSystem(
        @PathVariable("id")
        id: Long,
    ): ResponseEntity<SystemMetaEntity> {
        return ResponseEntity(data = systemService.getSystem(id))
    }

    @PostMapping
    @Operation(summary = "시스템 추가", description = "시스템 정보를 추가한다.")
    fun addSystem(
        @RequestBody
        systemDto: SystemDto
    ): ResponseEntity<SystemMetaEntity>? {
        return ResponseEntity(data = systemService.addSystem(systemDto))
    }

    @PostMapping("{id}/permissions")
    @Operation(summary = "시스템의 권한 추가", description = "시스템 권한을 추가한다.")
    fun addSystemPermission(
        @PathVariable("id")
        id: Long,
        @RequestBody
        systemPermissionDto: SystemPermissionDto
    ): ResponseEntity<SystemMetaEntity>? {
        return ResponseEntity(data = systemService.addSystemPermission(id, systemPermissionDto))
    }

    @PostMapping("{systemId}/permissions/{permissionId}/user")
    @Operation(summary = "시스템의 권한에 사용자 추가", description = "시스템 권한에 사용자 추가한다.")
    fun addSystemPermissionUser(
        @PathVariable("permissionId")
        id: Long,
        @RequestBody
        systemPermissionUserDto: SystemPermissionUserDto
    ): ResponseEntity<SystemPermissionEntity>? {
        return ResponseEntity(data = systemService.addSystemPermissionUser(id, systemPermissionUserDto))
    }
}