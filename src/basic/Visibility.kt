package basic

/**
 * Created by yuhp@terminus.io on 2017/7/18.
 * Desc:
 */

open class Outer {
    private val a = 0
    protected open val b = 1
    internal val c = 2
    val d = 3

    protected class Nested {
        public val e = 4
    }

}

class SubOuter : Outer() {
    override val b = 3
}

class Unrelated(what: Outer) {
    var what: Outer
        get() = what
        set(value) {
            this.what = what
        }

    fun asd() {
        what.c
        what.d
    }
}

class Foo{
    fun Outer.foo() {
        println("Outer foo")
    }

    fun caller(outer: Outer) {
        outer.foo()
    }
}

fun main(args: Array<String>) {
    whenTest(1)
    val man = Man()
    man.eat("apple")

    val foo = Foo()
    val outer = Outer()
    foo.caller(outer)

    val customer = Customer()
    println(customer.component1())
    val customer2 = customer.copy()
    val customer3 = customer.copy(name = "3")
    val (name,email) = customer3.copy(name = "pair",email = "email")
    println(customer)
    println(customer2)
    println(customer3)
}