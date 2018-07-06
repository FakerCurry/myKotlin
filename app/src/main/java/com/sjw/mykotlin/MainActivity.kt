package com.sjw.mykotlin

import android.graphics.Color
import android.nfc.Tag
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.util.Log
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

const val Tag = "MainActivity"

class MainActivity : AppCompatActivity() {

    //    var Tag = "MainActivity"
    var number = 12
    val str = "字符串"
    val bool = true
    val char = 'D'
    var float = 12f
    var double = 12.0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        kotlin_tv.setTextSize(20f)
        kotlin_tv.setText("kotlin_tv")
        kotlin_tv.setTextColor(Color.RED)

        kotlin_tv.setOnClickListener { View -> e("点击") }
        //定义  val/var 变量名:类型 =xxx
//        val number: Int = 12
//        val str: String = "字符串"
//        val bool: Boolean = true
//        val char: Char = 'D'
//        var float: Float = 12f
//        var double: Double = 12.0
        //自动推导类型

//        Tag = "tag"
//        Log.i(Tag, "number->" + number)
        val sum = add(1, 2);

        val sub = minus(10, 1);

        Toast.makeText(this, "number->" + number, Toast.LENGTH_LONG).show();
        //字符串模板
        e("你好吗加:${sum}122 减:${sub}sub")
        //打印$sa
        e("\$sa")
        //打印$1000
        val sarary = 1000;
        e("$$sarary")

        //类型转换
        var numberStr: String;
        numberStr = number.toString()

        number = numberStr.toInt()


        numberStr = "字符串"
        e("${numberStr == str}")
        e("${numberStr.equals(str)}")

        var person1 = Person()
        var person2 = Person()
        e("${person1.equals(person2)}")
        e("${person1 == person2}")

        //任何对象都可以分为可空和不可空
        var token = token()
        if (token != null) {
            var length = token.length
            e("长度是:${length}")

        }

        //数组，集合
//        int[] arr={1,2,3,4}
        var intArrs = intArrayOf(1, 2, 3, 4)
        e("intArrs[0]->${intArrs[3]}")
//        floatArrayOf()
//          doubleArrayOf()
        //字符串数组
        var strArr = arrayOf("str1", "", "str2", "", "str3")

//        for (intArr in intArrs) {
//            e(intArr.toString())
//        }

        //角标遍历
        for (i in intArrs.indices) {
            e("第${i}个")
        }

        //区间
        var intRange = IntRange(0, intArrs.size)//[0,3] 0,1,2,3

        var intRange1 = 0..intArrs.size//[0,3] 0,1,2,3

        var intRange2 = 0 until intArrs.size  //[0,3)0,1,2

        //需求：过滤掉strArr中的“”的字符串
        //步骤：1.创建一个新的集合来存放空字符串数组
        //2.遍历数组判断字符串是否为空
        //3.遍历数组
        strArr.filter { it.isNotEmpty() }
                .forEach { e(it) }

        //when 表达式 java switch  case
        var num = 1
        when (num) {

            1 -> e("is 1")
            1 -> e("is 2")
            in 1..3 -> e("in 1..3")
        }

        var numberStrWhen = when (num) {

            1 -> "1"
            1 -> "2"
            else -> {
                ""
            }
        }
        e("numberStrWhen->${numberStrWhen}")


    }


}

fun token(): String? {
    return null;
}


//fun add(number1: Int, number2: Int): Int {
//    return number1 + number2
//}

fun add(number1: Int, number2: Int) = number1 + number2

//在kotlin里面函数是可以作为变量的，函数可以作为参数传递
//var minus = fun(number1: Int, number2: Int): Int {
//    return number1 - number2
//}
//lambda初探
//表达式  函数入口参数->返回值
var minus = { number1: Int, number2: Int -> number1 - number2 }

//定义一个函数
fun e(message: String): Unit {
    Log.e(Tag, message)

}
