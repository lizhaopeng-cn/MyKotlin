package com.lzp.mykotlin

import android.util.Log

//默认public
open class Person(open val name: String, var address: String = "苏州", var age: Int, var isMarried: Boolean) {
    //自定义访问器
    val canWork: Boolean
        get() = age > 16

    init {
        Log.i("test", "init")
    }
}

class Police(override val name: String, val hasGun: Boolean): Person(name, "", 0, false){

}

//不能被实例化
class Student private constructor(){}

//从构造函数
open class people {
    constructor(name: String)
}

class Teacher: people{
    constructor(name: String, age: Int): this(name, age, "")
    constructor(name: String, age: Int, address: String) : super(name)
}