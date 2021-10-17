fun main() {
    println("--------Map with String--------------")
    val mySet1: MySet<String> = MySetImpl(listOf("qwe", "asdfa", "asfdg", "dgghsa", "asgg", "Hello"))
    println(mySet1)
    println(mySet1.map { ms -> ms + "asd" })

    println("--------Map with Int--------------")
    val mySet2: MySet<Int> = MySetImpl(listOf(2, 5, 3, 6, 1))
    println(mySet2)
    println(mySet2.map { ms -> ms * 2 })

    println("------Filter with Int----------------")
    val mySet3: MySet<Int> = MySetImpl(listOf(2, 5, 1, 54, 23, 6, 56, -4, 18, 0))
    println(mySet3)
    println(mySet3.filter { ms -> ms > 20 })

    println("---------Filter with String-------------")
    val mySet4: MySet<String> = MySetImpl(listOf("sdfdg", "gsd", "fgd", "hdsg", "gdfyu", "ashdg"))
    println(mySet4)
    println(mySet4.filter { ms -> ms.contains("df") })

    println("---------With-------------")
    fun testWith() = with(StringBuilder()) {
        for (l in 'A'..'Z')
            append(l)
        toString()
    }
    println(testWith())

    println("---------Apply-------------")
    fun testApply() = StringBuilder().apply {
        for (l in 'A'..'Z')
            append(l)
    }
    println(testApply())

    println("---------Let-------------")
    var str: String? = null
    str?.let { println(this) }
    str = "not null"
    str.let { println(this) }

    println("---------Also-------------")
    var let1 = "let1"
    var let2 = "let2"
    let1 = let2.also { let2 = let1 }
    println("let1=$let1, let2=$let2")
}

fun <T, R> with(receiver: T, block: T.() -> R): R {
    return receiver.block()
}

fun <T> T.apply(block: T.() -> Unit): T {
    block()
    return this
}

fun <T, R> T.let(block: T.() -> R): R {
    return block(this)
}

fun <T> T.also(block: (T) -> Unit): T {
    block(this)
    return this
}