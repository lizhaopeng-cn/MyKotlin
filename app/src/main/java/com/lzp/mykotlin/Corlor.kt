package com.lzp.mykotlin

/**
 * Created by lzp on 2018/12/8.
 */
enum class Color(val r: Int, val g: Int, val b: Int) {
    RED(255, 255, 0),
    ORANGE(255, 165, 0),
    YEELOW(255, 255, 0),
    GREEN(0, 255, 0),
    BLUE(0, 0, 255),
    INDIGO(75, 0, 130),
    VIOLEF(238, 130,238);

    fun rgb() = (r * 256 + g) * 256 + b
}