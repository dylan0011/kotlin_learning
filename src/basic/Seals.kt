package basic

/**
 * Created by yuhp@terminus.io on 2017/7/21.
 * Desc: 密封类 可以类比enum类型。但是比enum更灵活，其中的类型，可以是各种其他数据结构
 */

sealed class FourOperations
data class Add(val a:Int,val b:Int):FourOperations()
data class Minus(val a:Int,val b:Int):FourOperations()
data class Divide(val a:Int,val b:Int):FourOperations()
object Nan:FourOperations()

fun eval(eval: FourOperations) = when (eval) {
    is Add -> eval.a + eval.b
    is Minus -> eval.a - eval.b
    is Divide -> eval.a / eval.b
    Nan -> Double.NaN
}


sealed class Expr
data class Const(val number: Double) : Expr()
data class Sum(val e1: Expr, val e2: Expr) : Expr() object NotANumber : Expr()

fun eval(expr: Expr): Double = when(expr) { is Const -> expr.number
    is Sum -> eval(expr.e1) + eval(expr.e2)
    NotANumber -> Double.NaN
// 不再需要 `else` 子句，因为我们已经覆盖了所有的情况
}
