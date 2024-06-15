package com.springboot.test.core.db.entity

import com.springboot.test.core.type.TargetType
import jakarta.persistence.*

@Entity
@Table(name = "system_meta")
data class SystemMetaEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "system_id")
    var systemId: Long? = -1,

    @Column(name = "system_name")
    var systemName: String,

    @Column(name = "owner_target_id")
    var ownerTargetId: Long,

    @Column(name = "owner_target_type")
    var ownerTargetType: TargetType,

    @OneToMany
    var systemPermissionList: List<SystemPermission>? = listOf()
) : BaseEntity()
