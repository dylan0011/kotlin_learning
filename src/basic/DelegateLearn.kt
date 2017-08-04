package basic

import kotlin.reflect.KProperty
import kotlin.reflect.full.extensionReceiverParameter

/**
 * Created by yuhp@terminus.io on 2017/7/26.
 * Desc: 类委托 delegate
 */

interface Base {
    fun print()
}

class BaseImpl(val x: Int) : Base {
    override fun print() {
        print(x)
    }
}

class Derived(ba: Base) : Base by ba {
    override fun print() {
        println(">.<")
    }
}

class Example {
    var p: String by Delegate()
    var i=1
    val lazylazy : String by lazy {
        println("first init")
        "lazy-lazy${i++}"//后续调用，只返回调用的结果
    }
//    val observable =
}

class Delegate {
    operator fun getValue(example: Example, property: KProperty<*>): String {
        println( "$example, thank you for delegating '${property.name}' to me!")
        return ""
    }

    operator fun setValue(thisRef: Example, property: KProperty<*>, value: String) {
        println("$value has been assigned to '${property.name} in $thisRef.'")
    }
//    operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
//        return "$thisRef, thank you for delegating '${property.name}' to me! property value is ${property.getter}"
//    }
//
//    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
//        println("$value has been assigned to '${property.name} in $thisRef.'")
//    }
}


fun main(args: Array<String>) {
    val a = BaseImpl(10)
    Derived(a).print()

    val example = Example()

    println(example.p)
    example.p = "dylan"
    println(example.p)
    println(example.lazylazy)
    println(example.lazylazy)

}

