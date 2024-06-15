package com.springboot.test.core.db.repository

import com.springboot.test.core.db.entity.SystemMetaEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface SystemRepository : JpaRepository<SystemMetaEntity, Long> {
    fun findAllBy(): List<SystemMetaEntity>

}