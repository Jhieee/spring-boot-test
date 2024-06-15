package com.springboot.test.core.db.repository

import com.springboot.test.core.db.entity.SystemMetaEntity
import com.springboot.test.core.db.entity.SystemPermissionEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface SystemPermissionRepository : JpaRepository<SystemPermissionEntity, Long> {
    fun findAllBy(): List<SystemPermissionEntity>

}