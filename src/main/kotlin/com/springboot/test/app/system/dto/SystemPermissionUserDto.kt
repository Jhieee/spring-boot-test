package com.springboot.test.app.system.dto

import com.springboot.test.core.db.entity.SystemPermissionEntity
import com.springboot.test.core.db.entity.SystemPermissionUserEntity
import com.springboot.test.core.type.TargetType

class SystemPermissionUserDto(
    var systemPermissionUserId: Long? = -1,
    var targetId: Long,
    var targetType: TargetType,
) {
    companion object {
        fun of(systemPermissionEntity: SystemPermissionUserEntity): SystemPermissionUserDto {
            return SystemPermissionUserDto(
                systemPermissionUserId = systemPermissionEntity.systemPermissionUserId,
                targetId = systemPermissionEntity.targetId,
                targetType = systemPermissionEntity.targetType,
            )
        }

        fun toEntity(systemPermissionUserDto: SystemPermissionUserDto): SystemPermissionUserEntity {
            return SystemPermissionUserEntity(
                systemPermissionUserId = systemPermissionUserDto.systemPermissionUserId,
                targetId = systemPermissionUserDto.targetId,
                targetType = systemPermissionUserDto.targetType,
            )
        }
    }
}