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
 * 1.函数结构
 * 2.变量
 * 3.字符串模板
 * 4.类属性访问器-自定义访问器
 * 5.目录-包-类名
 * 6.枚举类
 * 7.when
 * 8.智能类型转换 is
 * 9..while，do while, for, map，in 检查区间集合
 * 10.异常
 * 11.指定命名参数与顺序
 * 12.顶层函数/顶层属性的调用（kotlin,java）
 * 13.扩展函数和属性
 * 14.可变参数varage和展开运算符*
 * 15.三重引号
 * 16.局部函数
 * 17.继承和实现
 * 18.open 、final 和abstract 修饰符：默认为final
 * 19.public、internal、protected、private
 * 20.内部类和密封类
 * 21.构造方法
 * 22.接口属性
 * 23.访问器支持字段与可见性
 * 24.数据类data
 * 25.类委托 by
 * 26.对象声明 单例object
 * 27.伴生对象
 * 28.lambda 访问变量
 * 29.lambda 成员引用
 * 30.集合函数api
 * 31.惰性集合序列
 * 32.Java函数式接口
 * 33.lambda-with/apply
 */

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val textView: TextView = findViewById(R.id.textView)
        textView.setOnClickListener{
            val a = 1
            var b = 2
//            a = 3
            b = 4
            // 字符串模版
            Log.i("test","a = $a")
            Log.i("test","a + b = ${a + b}")
            //字符串连接（字符串放前面）
            Log.i("test", "a * b = " + a*b)
            val p: Person = Person("zhangsan", "苏州", 18, true)
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

            Log.i("test", """\n extAtt-${'$'}{"wejsd".lastIndex}aaa
                |bbb
            """.trimMargin())

//            解构声明，将类解构成变量
//
//            var user = User("代码如此多娇", 27, "man")
//            var (name, age, sex) = user
//            println("$name,$age,$sex")

            //data数据类
            val c = Computer("i5", 1)
            val c1 = Computer("i7", 2)
            val c2 = Computer("i7", 2)
            Log.i("test", "data-${c.hashCode()}-${c.toString()}")
            Log.i("test", "data-${c1.hashCode()}-$c1")
            Log.i("test", "data-${c1.hashCode()}-$c1")
            Log.i("test", "data-${c1 == c2}")

            //lambda
            val c3 = Computer("i7", 5)
            val list = listOf(c, c1, c3)
            Log.i("test", "lambad-${list.maxBy({ c: Computer -> c.cpu })}")
            Log.i("test", "lambad-${list.maxBy { it.display }}")

            val sum = { x: Int, y: Int -> x + y }
            Log.i("test", "${sum(1, 2)}")

            val printValue =  run { Log.i("test", "printValue") }

            val sum1 = { x: Int, y: Int ->
                x * y
                x + y}
            Log.i("test", "${sum1(1, 2)}")

            foo("forEach")

            //lambda 成员引用
            Log.i("test", "lambad-${list.maxBy(Computer::display)}")
            Log.i("test", "lambad-${run(::topString)}")
            Log.i("test", "lambad-${run(::topMethod)}")
//            Log.i("test", "lambad-${String::isNF}")
//            Log.i("test", "lambad-${"4sdf"::isNF}")
//            Log.i("test", "lambad-${String::extText}")

            //延期创建类实例
            val creatComputer = ::Computer
            val c4 = creatComputer("i7", 5)

            //可空性
            val text = null
            val test1: String? = "123"
            fun n(s: String) = s.length
//            n(test)
            fun n1(s: String?) = if (s != null) s.length else null // s ?.length
            fun n2(s: String?) = if (s != null) s else "" // s ?: ""
            fun n3(s: String?) = if (s is String) s else null // s as? ""
            fun n4(s: String?) = if (s != null) s else "NullPointerException" // s!!
            fun n5(s: String?) {
                if (s != null) s.length//s?.let { it.length }
            }

            j.judgeEquals()
            kk()
        }
    }

    /**
     * 集合
     */
    fun coll(): java.lang.StringBuilder{
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
        return str
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

    /**
     * 局部函数
     */
    fun writePerson(p: Person, date: String) {
        fun localMed(value: String, name: String) =
            if (value.isEmpty()) "$date $name=null" else "$name=$value"

        localMed(p.name, "name")
        localMed(p.address, "address")
    }

    fun kk(){
        //        val a: Int = 'a'
        val aa: Int = 'a'.toInt()

        val a: Int = 128
        val b: Int? = a
        val c: Int? = a
        Log.i("test", "equals-${a == b}")
        Log.i("test", "equals-${a === b}")
        Log.i("test", "equals-${c == b}")
        Log.i("test", "equals-${c === b}")

        val a1: Int = 1
//        val b1: Double = a1 // kotlin 不能由低到高自动类型转换
        val c1: Double = a1.toDouble()
        val d1: Double = a1 + 1.5
        val e1: Double = a1.plus(1.5)

        //数组
        val list = listOf<String>("a", "b", "c")
        val array = list.toTypedArray();

        val array1 = arrayOf("d", "e", "f")
        val array2 = arrayOfNulls<Int>(3)
        array2[0] = 5
        array2.set(1, 9)
        val array3 = arrayOfNulls<String>(3)
        array3[0] = "g"
        array3.set(1, "h")
        val array4 = IntArray(3){i -> i + 2 }
        array.forEach { Log.i("test", it) }
        array1.forEach { Log.i("test", it) }
        array2.forEach { Log.i("test", it.toString()) }
//        array3.forEach { Log.i("test", it) }
        array4.forEach { Log.i("test", it.toString()) }
        Log.i("test", "array1[2]-${array1[2]}") // 字符串模版
        Log.i("test", "array2[2]-" + array2[2]) // 字符串连接，必须第一个是字符串
        Log.i("test", "array3[2]-" + array3[2])
        Log.i("test", "array4[2]-${array4.get(2)}")

        val aaa = """aaa\nbbb""" // 字符串字面值
        Log.i("test", aaa)
    }

    fun foo(title: String) {
        var count: Int = 0
        listOf(1, 2, 3, 4, 5).forEach {
            if (it == 3)
                count++
                return@forEach
            Log.i("test",it.toString())
        }
        Log.i("test","$title $count this point is unreachable")
    }
}

open class ClassA(){
    open fun showText() = "ClassA"
}

interface ClickableA {
    fun showText() = "ClickableA"
}

interface ClickableB {
    fun click()
    fun showText() = "ClickableB"
}

abstract class AbstractA {
    abstract fun click()
    open fun showText() = "AbstractA"
}

open class TextView: ClassA(), ClickableA, ClickableB {
    override fun click() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    //父类方法open，默认open
    final override fun showText(): String {
        return super<ClickableA>.showText()
    }

}

class Button: com.lzp.mykotlin.TextView() {
//    override fun showText(): String {
//        return super.showText()
//    }
}

class MyView: AbstractA() {
    override fun click() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showText(): String {
        return super.showText()
    }
}

//接口属性
interface User{
    val name: String
    val age: Int
        get() = name.length
}

// name 覆盖值
// address 访问器支持字段
class PrivateUser(override val name: String) : User {
    var address: String = "address"
        private set(value) { // 访问器只能类内修改
            Log.i("test", "$field")
            field = value
        }
}
// name 调用获得
class SubscribingUser(val email: String) : User {
    override val name: String
        get() = email.substringBefore('@')
}
// name 存储值
class FacebookUser(val accountId: Int): User {
    override val name: String = getUserName(accountId)

    private fun getUserName(accountId: Int): String {
        return accountId.toString()
    }
}

//数据类data
data class Computer(val cpu: String, var display: Int){
    fun printComputerLog() {
        Log.i("test", "printComputerLog")
    }
}