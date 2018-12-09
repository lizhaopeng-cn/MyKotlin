package com.lzp.mykotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.lzp.mykotlin.Color.*
import com.lzp.yourkotlin.count
import com.lzp.yourkotlin.isNumFirst as isNF
import com.lzp.yourkotlin.topMethod
import com.lzp.yourkotlin.topString
import java.util.*

/**
 * kotlin
 * 7.枚举类
 * 8.when
 * 9.智能类型转换 is
 * 10.while，do while, for, map，in 检查区间集合
 * 11.异常
 * 12.指定命名参数与顺序
 * 13.顶层函数/顶层属性的调用（kotlin,java）
 * 14.扩展函数和属性
 * 15。可变参数varage和展开运算符*
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val textView: TextView = findViewById(R.id.textView)
        textView.setOnClickListener{it -> foo()
            val a = 1
            var b = 2
//            a = 3
            b = 4
            // 字符串模版
            Log.i("test","a = $a")
            Log.i("test","a + b = ${a + b}")
            //字符串连接（字符串放前面）
            Log.i("test", "a * b = " + a*b)
            val p: Person = Person("zhangsan", 18, true)
            p.age = 11
            p.isMarried = false

            val j = JavaUtils()
            val p1 = j.p
            Log.i("test", "\nname = ${p1.name}\nage = ${p1.age}\nisMarried = ${p1.isMarried}\ncanWork = ${p1.canWork}")

            Log.i("test", "coll-${coll()}")

            Log.i("test", Color.BLUE.rgb().toString())

            Log.i("test", "mixcolor-${mixColor(YEELOW, RED)}")
            Log.i("test", "mixcolor-${mixColor(YEELOW, GREEN)}")

            Log.i("test", "mixColorNoPara-${mixColorNoPara(YEELOW, RED)}")
            Log.i("test", "mixColorNoPara-${mixColorNoPara(YEELOW, GREEN)}")

            Log.i("test", "add-${add(Sum(Sum(Num(1), Num(2)), Num(3)))}")
            Log.i("test", "addWhen-${addWhen(Sum(Sum(Num(1), Num(2)), Num(3)))}")

            Log.i("test", "${abc()}")
            Log.i("test", "${agetMap()}")

            Log.i("test", "inArea-${inArea('6')}")
            Log.i("test", "inColl-${inColl()}")

            para(5, "qwer", false)
            para(b = true, i = 1, s = "123")
            para1(5, "aaa", s1 = "bbb")

            Log.i("test", "topMethod-${topMethod()}")
            Log.i("test", "topAtt-${count}")
            Log.i("test", "topAtt-${topString}")

            Log.i("test", "extMethod-${"897ssdf".isNF()}")
            Log.i("test", "extAtt-${"wejsd".lastIndex}")

        }
    }

    /**
     * 集合
     */
    fun coll(){
        val list = listOf(1, 2, 3)
        val set = hashSetOf(4, 5, 6)
        val map = hashMapOf(7 to "seven", 8 to "eight", 9 to "nine")
        val str = StringBuilder()
        for (i in list){
            str.append("$i ")
        }
        for (s in set){
            str.append("$s ")
        }
        for ((k, v) in map){
            str.append("$k,$v ")
        }
    }
    /**
     * when的参数可以是任意对象
     */
    fun mixColor(c1: Color, c2: Color) =
            when (setOf(c1, c2)) {
                setOf(RED, YEELOW) -> ORANGE
                setOf(YEELOW, BLUE) -> GREEN
                else -> "no color"
            }

    /**
     * when可以没有参数，直接判断条件是否成立
     */
    fun mixColorNoPara(c1: Color, c2: Color) =
            when {
                (c1 == RED && c2 == YEELOW) || (c1 == YEELOW && c2 == RED) -> ORANGE
                (c1 == YEELOW && c2 == BLUE) || (c1 == BLUE && c2 == YEELOW) -> GREEN
                else -> "no color"
            }

    interface Expr
    class Num(val value: Int) : Expr
    class Sum(val left: Expr, val right: Expr) : Expr

    /**
     * 最后的表达式即为返回的值
     */
    fun add(e: Expr): Int =
    if (e is Num) {
//            val n = e as Num
//            return n.value
        e.value
    } else if ((e is Sum)){
        add(e.left) + add(e.right)
    } else {
        0
    }


    /**
     * when用is判断
     */
    fun addWhen(e: Expr): Int =
            when (e) {
                is Num -> e.value
                is Sum -> addWhen(e.left) + addWhen(e.right)
                else -> 0
            }

    /**
     * for循环
     */
    fun abc(): StringBuilder {
        val str = StringBuilder()
//        for (i in 1..100) {
//        for (i in 1 until 100) {
        for (i in 100 downTo 1 step 2) {
            when{
                i % 15 == 0 -> str.append("ab ")
                i % 3 == 0 -> str.append("a ")
                i % 5 == 0 -> str.append("b ")
                else -> str.append("$i ")
            }
        }
        return str
    }

    /**
     * 迭代map
     */
    fun agetMap(): StringBuilder {
        val treeMap = TreeMap<Char, Int>()
        for (k in 'a'..'f') {
            treeMap[k] = k.toInt()
        }
        val str = StringBuilder()
        for ((k,v) in treeMap) {
            str.append("$k=$v ")
        }
        return str
    }

    /**
     * in检查区间
     */
    fun inArea(c: Char) =
            when (c) {
                in '0'..'9' -> "数字"
                in 'a'..'z', in 'A'..'Z' -> "字母"
                else -> "不知道"
            }

    /**
     * in检查集合
     */
    fun inColl() = "Kotlin" in listOf<String>("Java", "JS", "C++")

    /**
     * 函数参数初始化
     */
    fun para(i: Int, s: String, b: Boolean){
        Log.i("test", "$i $s $b")
    }

    /**
     * 函数参数调用顺序
     */
    fun para1(i: Int = 0, s: String, b: Boolean = false, s1: String = "s1"){
        Log.i("test", "$i $s $b")
    }

    /**
     * 顶层函数都同名函数
     */
    fun isNumFirst(): Boolean {
        return true
    }

    fun foo() {
        listOf(1, 2, 3, 4, 5).forEach {
            if (it == 3)
                return@forEach
            Log.i("test",it.toString())
        }
        Log.i("test","this point is unreachable")
    }
}
