package com.springboot.test.core.db.entity

import com.fasterxml.jackson.annotation.JsonBackReference
import com.springboot.test.core.type.TargetType
import jakarta.persistence.*


@Entity
@Table(name = "system_permission")
data class SystemPermissionUserEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "system_permission_user_id")
    var systemPermissionUserId: Long? = null,

    @Column(name = "target_id")
    var targetId: Long,

    @Column(name = "target_type")
    var targetType: TargetType,

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SYSTEM_PERMISSION_ID")
    var systemPermission: SystemPermissionEntity? = null
) : BaseEntity() {
    fun addSystemPermission(systemPermissionEntity: SystemPermissionEntity) {
        this.systemPermission = systemPermissionEntity
    }
}

