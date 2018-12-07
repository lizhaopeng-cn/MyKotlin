package com.lzp.mykotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

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
        }


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
