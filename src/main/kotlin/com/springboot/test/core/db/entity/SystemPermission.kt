package com.springboot.test.core.db.entity

import jakarta.persistence.*

@Entity
@Table(name = "system_permission")
data class SystemPermission(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "system_permission_id")
    var systemPermissionId: Long? = -1,

    @Column(name = "system_permission_name")
    var permissionName: String,

    @Column(name = "system_permission_desc")
    var permissionDesc: String,

    @ManyToOne
    var systemMeta: SystemMetaEntity
) : BaseEntity()
