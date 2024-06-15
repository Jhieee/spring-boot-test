package com.springboot.test.app.system.service

import com.springboot.test.app.system.dto.SystemDto
import com.springboot.test.core.db.entity.SystemMetaEntity
import com.springboot.test.core.db.repository.SystemRepository
import org.springframework.stereotype.Service

@Service
class SystemService(
//    private val systemMeta: SystemMeta
    private val systemRepository: SystemRepository
) {
    fun getSystemAll(): List<SystemMetaEntity>? {
        return systemRepository.findAllBy()
    }

    fun addSystem(systemDto: SystemDto): SystemMetaEntity {
        return systemRepository.save(SystemDto.toEntity(systemDto))
    }
}