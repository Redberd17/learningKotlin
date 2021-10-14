fun main() {
    val mySet1: MySet<String> = MySetImpl(listOf("qwe", "asdfa", "asfdg", "dgghsa", "asgg", "Hello"))
    println(mySet1.map { ms -> ms + "asd" })

    val mySet2: MySet<Int> = MySetImpl(listOf(2, 5, 3, 6, 1))
    println(mySet2)
    println(mySet2.map { ms -> ms * 2})
}