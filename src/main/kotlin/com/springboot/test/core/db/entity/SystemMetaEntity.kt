package com.springboot.test.core.db.entity

import com.fasterxml.jackson.annotation.JsonManagedReference
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

    @Column(name = "system_code")
    var systemCode: String?,

    @Column(name = "owner_target_id")
    var ownerTargetId: Long,

    @Enumerated(value = EnumType.ORDINAL)
    @Column(name = "owner_target_type")
    var ownerTargetType: TargetType,

    @JsonManagedReference
    @OneToMany(mappedBy = "systemMeta", fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    var systemPermissions: MutableList<SystemPermissionEntity> = ArrayList()

) : BaseEntity() {

}