package basic

/**
 * Created by yuhp@terminus.io on 2017/7/24.
 * Desc: 对象表达式 和 对象声明
 */

interface Factory<out T> {
    fun create(): T
}

class CompanionTest {
    companion object : Factory<Foo> {
        override fun create(): Foo = Foo()
    }
}

open class AA(x: Int) {
    public open val y: Int = x
}

fun foo() {
    val adHoc = object {
        var x: Int = 0
        var y: Int = 0
    }
    print(adHoc.x + adHoc.y)
}

interface BB

val ab: AA = object : AA(1), BB {
    override val y = 15
}