fun main() {

    val mySet1: MySetImpl<String> = MySetImpl(listOf("qwe", "asdfa", "asfdg", "dgghsa", "asgg", "Hello"))
    println("constructor by collection mySet1: $mySet1")

    val mySet: MySetImpl<String> = MySetImpl()

    //test add
    mySet.add("Hello")
    mySet.add("Hi")
    mySet.add("Hel")
    mySet.add("Helli")
    mySet.add("Hello")
    mySet.add("Hellos")
    mySet.add("asdfa")

    println("toString mySet: $mySet")

    println("set3 = mySet + mySet1: ${mySet + mySet1}")
    println("set3 = mySet - mySet1: ${mySet1 - mySet}")

    mySet.remove("Hel")

    //test size
    println(mySet.size())

    //test addAll
    mySet.addAll(listOf("new1", "new2"))

    println(mySet.toString())

    //test contains
    println("Contains Hello: ${mySet.contains("Hello")}")
    println("Contains Hellasdo: ${mySet.contains("Hellasdo")}")

    //test removeAll
    mySet.removeAll(listOf("new2", "Helli"))
    println("After remove new2 and Helli: $mySet")

    //test isEmpty
    println("isEmpty: ${mySet.isEmpty()}")

    //test clear
    mySet.clear()
    println("Clear map: $mySet")

    //test isEmpty
    println("isEmpty: ${mySet.isEmpty()}")
}