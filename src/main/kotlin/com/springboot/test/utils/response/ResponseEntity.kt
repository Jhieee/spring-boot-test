package com.springboot.test.utils.response

class ResponseEntity<T> (
    var success: Boolean = true,
    var code: String = "0000",
    var data: T
)