package com.springboot.test.core.db.repository

import com.springboot.test.core.db.entity.SystemMetaEntity
import com.springboot.test.core.db.entity.SystemPermissionEntity
import com.springboot.test.core.db.entity.SystemPermissionUserEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface SystemPermissionUserRepository : JpaRepository<SystemPermissionUserEntity, Long> {
    fun findAllBy(): List<SystemPermissionUserEntity>
    fun findAllSystemPermissionUserId(id: Long): SystemPermissionUserEntity

}