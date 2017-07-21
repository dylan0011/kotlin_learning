package basic

/**
 * Created by yuhp@terminus.io on 2017/7/21.
 * Desc: 泛型
 */
abstract class Source<out T>{
    abstract fun next(): T
}

fun demo(strs: Source<String>) {
    val objects:Source<Any> = strs
}