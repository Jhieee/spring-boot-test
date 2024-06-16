package com.springboot.test.core.db.entity

import com.fasterxml.jackson.annotation.JsonBackReference
import com.fasterxml.jackson.annotation.JsonManagedReference
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

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SYSTEM_ID")
    var systemMeta: SystemMetaEntity? = null,

    @JsonManagedReference
    @OneToMany(mappedBy = "systemPermission", fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    var systemPermissionUsers: MutableList<SystemPermissionUserEntity> = ArrayList()


) : BaseEntity() {
    fun addSystem(systemMeta: SystemMetaEntity) {
        this.systemMeta = systemMeta
    }
}

