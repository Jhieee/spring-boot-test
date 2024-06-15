package com.springboot.test.app.system.dto

import com.springboot.test.core.db.entity.SystemMetaEntity
import com.springboot.test.core.type.TargetType

class SystemDto(
    var systemName: String,
    var ownerTargetId: Long,
    var ownerTargetType: TargetType,
) {
    companion object {
        fun of(systemMeta: SystemMetaEntity): SystemDto {
            return SystemDto(
                systemName = systemMeta.systemName,
                ownerTargetId = systemMeta.ownerTargetId,
                ownerTargetType = systemMeta.ownerTargetType
            )
        }

        fun toEntity(systemDto: SystemDto): SystemMetaEntity {
            return SystemMetaEntity(
                systemName = systemDto.systemName,
                ownerTargetId = systemDto.ownerTargetId,
                ownerTargetType = systemDto.ownerTargetType
            )
        }
    }
}
