@file:JvmName("TopClass")
package com.lzp.yourkotlin


/**
 * 顶层函数
 */
fun topMethod(): String {
    return "topMethod";
}
/**
 * 顶层属性
 */
val count: Int = 0
const val topString = "top_string"
/**
 * 扩展函数
 */
fun String.isNumFirst(): Boolean = this.get(0) in '0'..'9'

/**
 * 扩展属性
 */
val String.lastChar: Char
        get() = this.get(this.length - 1)
//        set(c: Char) {
//            this.elementAtOrElse(this.length - 1, c)
//        }
class KotlinUtils() {

}