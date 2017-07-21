package basic

import java.lang.Integer.parseInt
import java.util.*

/**
 * Created by yuhp@terminus.io on 2017/7/16.
 * Desc:
 */

data class Customer(val name: String ="name", val email: String="email")

fun sum(a: Int, b: Int): Int {
    return a + b
}

fun sum2(a: Int, b: Int) = a + b

fun noSense(): Unit {
    println("there is no sense")
}

fun noSenseWithVoid() {
    println("unit is void in java")
}

fun noSenseWith() = println("auto complete")

/**
 * final变量声明用val(l结尾)
 * 非final变量声明用var(r结尾)
 */
fun finalInstance() {
    val a: Int = 1 //一般而言 都可以做类型推导 不用特别声明为Int
    var b = 2
    var c: Int = 3
    println(a)
    c += 3
    println(c)
}

fun sdTest(arg: String) {
    val a = "star"
    val b = "star mean $a"
    println("${b.replace("mean", "means")}, $arg")
}

fun couldNull(str: String?) {
    if (str == null) {
        println(null)
    }
    var inta: Int
    try {
        inta = parseInt(str)
    } catch(e: Exception) {
        inta = 0
    }
    println(inta * 10)
    println("abc$str")
}

fun testMap() {
    val map = mapOf("a" to 1, "b" to 2, "c" to 3)
    for ((k, v) in map) {
        println("$k->$v")
    }
    println(map.keys)
    println(map.values)
    println(map.entries)
}

fun <K, V> Map<K, V>.test(k: K, v: V) {
    println("ahhh, $k -> $v")
}

/**
 * x is in range of [a,b]
 */
fun inRange(x: Int): Unit {
    if (x in 1..10) {//[1,10]
        println("$x is in range(1,[$(y+1)]")
    }
    if (x in 1 until 10) {//[1,10)
        println("$x is in range(1,[$(y+1)]")
    }
}

object Resource {
    val name = "dylan"
}

fun numbers() {
    val a = 1_000_000L
    println(a)

    val b: Int? = 1 // Int? 表示该变量可以为空
    val c: Int = 1
    var d = c.shl(2)
    val bol = false
    println(d)

}

fun arrays() {
    val ary: Array<Int> = arrayOf(1, 2, 3)

    // 创建一个 Array<String> 初始化为 ["0", "1", "4", "9", "16"]
    val asc = Array(5, { i -> (i * i).toString() })
    println(Arrays.toString(asc))

    for ((a, b) in asc.withIndex()) {
        println("index is $a and value is $b")
    }

    val str = "abcdefg"
    for (c in str) {
        print("$c  ")
    }

}

fun ifElse() {
    val bool = false
    val str = if (bool) "true" else "false"
    println(str)

    var result = if (str.equals("true")) {// 当==两边的对象都不为空时，== 会被翻译为equals 此处可以用 == 来替换equals
        println("str is true")
        true
    } else {
        false
    }
    println(result)

}

fun whenTest(x: Any) {
    when (x) {
        is String -> println("x is string")
        is Int -> println("x is Int")
        else -> println("x is anything")
    }
    when {
        x is String -> println("x is string")
        else -> println("ai you bu cuo o")
    }
}

fun <E> collectionTest(collection: Collection<E>) {
    loop@ for (e in collection) {
        loop2@ for (i in 6..9) {
            if (i == 7) {
                continue@loop2
            }
            if (i == 8) {
                break@loop
            }
            println("$e -> $i")
        }

    }
}

/**
 * 要么为继承而设计，并提供文档说明，要么就禁止继承
 */
open class People {
    var idea: String = "" //想法
    var name: String = ""
    var age: Int = 0

    init {
        println("instance initialized with name=$name,age=$age")
    }

    constructor()

    constructor(name: String, age: Int) {
        this.name = name
        this.age = age
    }

    constructor(name: String, age: Int, idea: String) {
        this.name = name
        this.age = age
        this.idea = idea
    }

    override fun toString(): String {
        return "name=$name,age=$age,idea=$idea"
    }

    fun birthday(birthday: Date?): Unit {
        println("happy birthday,$birthday")
    }

    open fun eat(sth: String): Unit {
        println("I'm eating $sth,It's delicious")
    }


}

open class Man : People() {
    var gender = 'M'

    init {
        println("123")

    }

    override fun eat(sth: String) {// 标记为override的成员或属性本身也是open的，如果要禁止继承，可以添加final关键字
        super.eat(sth)
        println("oh i really like id")
    }

}

open class Boy : Man() {

    val simple: Boolean get() = false

    /**
     * 幕后属性
     * 一般而言 对外提供一个val关键字定义的属性，对内提供一个var定义的属性
     * 则这个var属性称为幕后属性
     * 参见 {@link kotlin.collections.AbstractMap#}
     */
    private var _experience:String?=null
    val experience:String get(){
        return _experience?:"no experience"
    }

    var hobby: String
        get() = this.hobby
        protected set(value) {
            this.hobby = value
        }


    override fun eat(sth: String) {
        super.eat(sth)
    }

    fun fuck(sth: String) {
        this._experience = sth
    }
}


fun main(args: Array<String>) {
//    inRange(10)
//    inRange(1)
//    inRange(10)
//    testMap()
//    val map = mapOf<String,String>()
//    map.test("1", "2")
//    numbers()
//    arrays()
//    ifElse()
//    whenTest(1)
//    val list = listOf(1, 2, 3)
//    collectionTest(list)
//
//    val test = list ?: return

//    val new = People("dylan", 18)
//    val new2 = People("dylan", 18, "what the fuck")
//
//    println(new.toString())
//    println(new2)
//    new.age = 19
//    println(new.age)

    var boy = Boy()
    boy.fuck("girl")
    println(boy.experience)

}
