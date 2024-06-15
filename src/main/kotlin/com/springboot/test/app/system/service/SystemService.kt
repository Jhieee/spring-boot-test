package com.springboot.test.app.system.service

import com.springboot.test.app.system.dto.SystemDto
import com.springboot.test.app.system.dto.SystemPermissionDto
import com.springboot.test.core.db.entity.SystemMetaEntity
import com.springboot.test.core.db.entity.SystemPermissionEntity
import com.springboot.test.core.db.repository.SystemPermissionRepository
import com.springboot.test.core.db.repository.SystemRepository
import org.springframework.stereotype.Service

@Service
class SystemService(
//    private val systemMeta: SystemMeta
    private val systemRepository: SystemRepository,
    private val systemPermissionRepository: SystemPermissionRepository
) {
    fun getSystemAll(): List<SystemMetaEntity>? {
        return systemRepository.findAllBy()
    }

    fun addSystem(systemDto: SystemDto): SystemMetaEntity {
        return systemRepository.save(SystemDto.toEntity(systemDto))
    }

    fun addSystemPermission(systemId: Long, systemPermissionDto: SystemPermissionDto): SystemMetaEntity {
        systemPermissionDto.systemPermissionId = systemId
        val system = systemRepository.findBySystemId(systemId)
        system.addSystemPermission(SystemPermissionDto.toEntity(systemPermissionDto))
        return systemRepository.save(system)
    }
}