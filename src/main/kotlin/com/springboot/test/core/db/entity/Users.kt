package com.springboot.test.core.db.entity

import jakarta.persistence.*
import java.util.*

@Entity
data class Users(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var userId: Long,

    @Column(name = "USER_NAME")
    var userName: String,

    @Column(name = "GROUP_NAME")
    var groupName: String,

    @Column(name = "IS_ENABLE")
    var isEnable: Boolean,

    @Column(name = "CREATED_AT")
    var createdAt: Date,

    @Column(name = "UPDATED_AT")
    var updatedAt: Date
)