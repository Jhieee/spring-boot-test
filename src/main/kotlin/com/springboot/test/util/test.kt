package com.springboot.test.util

fun test() {
    runCatching {
        error()
    }.onSuccess {
        println(it)
        println("Success")
    }.onFailure {
        println(it)
        println("Failure")
    }.apply {
        println("apply")
    }.getOrThrow()
}
private fun pass() { }

private fun error() {
    throw Exception("error")
}