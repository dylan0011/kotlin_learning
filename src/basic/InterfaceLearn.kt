package basic

/**
 * Created by yuhp@terminus.io on 2017/7/18.
 * Desc:
 */
interface MyInterface {
    val prop: Int // 抽象的
    val propertyWithImplementation: String get() = "foo"
    fun foo() {
        println("super  $prop")
        println("super $propertyWithImplementation")
    }

    fun toInterface(x: Any): Unit
}

class Child : MyInterface {
    override fun toInterface(x: Any) {
        println("a ha")
    }

    override val prop: Int = 1
    override val propertyWithImplementation: String
        get() = "foo a"

    override fun foo() {
        super.foo()
        println("...$prop,$propertyWithImplementation,${super.foo()}")
    }
    init {
//        foo()
//        println("*******")
//        println("${super.foo()}")

    }
}

interface A{
    fun foo(){
        println("A is print")
    }
}
interface B{
    fun foo(){
        println("B is print")
    }
}
class C :A,B{
    override fun foo() {
        super<A>.foo()
        super<B>.foo()
    }
}

fun main(args: Array<String>) {
    Child().toInterface(1)
}