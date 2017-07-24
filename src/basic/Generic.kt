package basic

/**
 * Created by yuhp@terminus.io on 2017/7/21.
 * Desc: 泛型
 * 1.被声明为{@code out} 时，为生产者.  <? extends T> -- 协变
 * 2.被声明为{@code in}  时，为消费者. <? super T> -- 逆变
 * 这里的 out 和 in修饰符 称为型变注解
 *
 * 对输入逆变  对输出协变
 */
abstract class Source<out T> {
    abstract fun next(): T
}

fun demo(strs: Source<String>) {
    val objects: Source<Any> = strs
}

abstract class Comparable<in T> {
    abstract fun compareTo(other: T): Int
}

fun demo2(x: Comparable<Number>) {
    x.compareTo(1)
    val y: Comparable<Double> = x
    println(y)
}

fun copy(from: Array<out Any>, to: Array<in Any>): Unit {
    assert(from.size == to.size)
    for (i in from.indices) {
        to[i] = from[i]
    }
}

fun add(from: Transport<out Benz>, to: Transport<in Benz>) {


}

object Singleton{
    fun test(){
        println("...")
    }
}

open class Car
open class Benz(val brand: String) : Car()
open class SubBenz : Benz(brand = "Benz")

class Transport<T>

fun main(args: Array<String>) {
//    val ints: Array<Int> = arrayOf(1, 2, 3)
//    val any = Array<Any>(3) { "" }
//    copy(ints,any)
//    println(Arrays.toString(any))


    val car = Car()
    val subBenz = SubBenz()

    var t1 = Transport<Car>()
    var t2 = Transport<SubBenz>()


    add(t2, t1)

    Singleton.test()


}