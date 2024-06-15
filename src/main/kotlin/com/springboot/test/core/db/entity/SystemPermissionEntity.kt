package com.springboot.test.core.db.entity

import jakarta.persistence.*


@Entity
@Table(name = "system_permission")
data class SystemPermissionEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "system_permission_id")
    var systemPermissionId: Long? = null,

    @Column(name = "system_permission_name")
    var permissionName: String,

    @Column(name = "system_permission_desc")
    var permissionDesc: String? = null,

    @Column(name = "system_permission_code")
    var permissionCode: String?,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "system_id")
    var systemMeta: SystemMetaEntity? = null
) : BaseEntity() {
//
//    fun addSystemPermission(permissionEntity: SystemPermissionEntity) {
//        this.systemMeta = permissionEntity
//        systemPermissions.add(permissionEntity)
//
//    }
}

