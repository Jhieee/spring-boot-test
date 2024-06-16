package com.springboot.test.app.system.dto

import com.springboot.test.core.db.entity.SystemPermissionEntity

class SystemPermissionDto(
    var systemPermissionId: Long? = -1,
//    var systemId: Long = -1,
    var systemPermissionName: String,
    var systemPermissionDesc: String? = null,
    var systemPermissionCode: String? = null
) {
    companion object {
        fun of(systemPermissionEntity: SystemPermissionEntity): SystemPermissionDto {
            return SystemPermissionDto(
                systemPermissionId = systemPermissionEntity.systemPermissionId,
                systemPermissionName = systemPermissionEntity.permissionName,
                systemPermissionDesc = systemPermissionEntity.permissionDesc,
                systemPermissionCode = systemPermissionEntity.permissionCode,
            )
        }

        fun toEntity(systemPermissionDto: SystemPermissionDto): SystemPermissionEntity {
            return SystemPermissionEntity(
//                systemId = systemPermissionDto.systemId,
                systemPermissionId = systemPermissionDto.systemPermissionId,
                permissionName = systemPermissionDto.systemPermissionName,
                permissionDesc = systemPermissionDto.systemPermissionDesc,
                permissionCode = systemPermissionDto.systemPermissionCode,
            )
        }
    }
}