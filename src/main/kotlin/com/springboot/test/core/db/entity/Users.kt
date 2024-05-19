package com.springboot.test.core.db.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id

@Entity
data class Users (
    @Id
    @Column(name="id")
    var userId: Long,

    @Column(name="USER_NAME")
    var userName: String,

    @Column(name="GROUP_NAME")
    var groupName: String,

    @Column(name="IS_ENABLE")
    var isEnable: Boolean
)