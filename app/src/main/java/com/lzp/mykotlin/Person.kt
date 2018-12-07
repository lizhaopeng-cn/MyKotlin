package com.lzp.mykotlin
//默认public
class Person(val name: String, var age: Int, var isMarried: Boolean) {
    //自定义访问器
    val canWork: Boolean
        get() = age > 16
}