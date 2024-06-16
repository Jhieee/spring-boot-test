package com.springboot.test.app.system.service

import com.springboot.test.app.system.dto.SystemDto
import com.springboot.test.app.system.dto.SystemPermissionDto
import com.springboot.test.app.system.dto.SystemPermissionUserDto
import com.springboot.test.core.db.entity.SystemMetaEntity
import com.springboot.test.core.db.entity.SystemPermissionEntity
import com.springboot.test.core.db.entity.SystemPermissionUserEntity
import com.springboot.test.core.db.repository.SystemPermissionRepository
import com.springboot.test.core.db.repository.SystemPermissionUserRepository
import com.springboot.test.core.db.repository.SystemRepository
import org.springframework.stereotype.Service

@Service
class SystemService(
//    private val systemMeta: SystemMeta
    private val systemRepository: SystemRepository,
    private val systemPermissionRepository: SystemPermissionRepository,
    private val systemPermissionUserRepository: SystemPermissionUserRepository
) {
    fun getSystemAll(): List<SystemMetaEntity>? {
        return systemRepository.findAllBy()
    }

    fun getSystem(id: Long): SystemMetaEntity {
        return systemRepository.findBySystemId(id)
    }


    fun addSystem(systemDto: SystemDto): SystemMetaEntity {
        return systemRepository.save(SystemDto.toEntity(systemDto))
    }

    fun addSystemPermission(systemId: Long, systemPermissionDto: SystemPermissionDto): SystemMetaEntity {
        val system = systemRepository.findBySystemId(systemId)
        val systemPermission = SystemPermissionDto.toEntity(systemPermissionDto)

        systemPermission.addSystem(system)
        systemPermissionRepository.save(systemPermission)
        return systemRepository.save(system)
    }

    fun addSystemPermissionUser(
        permissionId: Long,
        systemPermissionUserDto: SystemPermissionUserDto
    ): SystemPermissionEntity {
        val systemPermission = systemPermissionRepository.findBySystemPermissionId(permissionId)
        val systemPermissionUser = SystemPermissionUserDto.toEntity(systemPermissionUserDto)
        systemPermissionUser.addSystemPermission(systemPermission)
        systemPermissionUserRepository.save(systemPermissionUser)
        return systemPermissionRepository.save(systemPermission)
    }
}