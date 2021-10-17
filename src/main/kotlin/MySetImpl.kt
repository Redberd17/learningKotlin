import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

class MySetImpl<T> : MySet<T> {

    private var map: HashMap<T, Any> = HashMap()

    private val present = Any()

    constructor()

    constructor(c: Collection<T>) : this() {
        addAll(c)
    }

    override fun isEmpty(): Boolean {
        return map.isEmpty()
    }

    override fun contains(t: T): Boolean {
        return map.containsKey(t)
    }

    override fun size(): Int {
        return map.size
    }

    override fun add(t: T): Boolean {
        return map.put(t, present) == null
    }

    override fun remove(t: T): Boolean {
        return map.remove(t) == present
    }

    override fun addAll(t: Collection<T>): Boolean {
        var modified = false
        for (o in t)
            if (add(o))
                modified = true
        return modified
    }

    override fun removeAll(t: Collection<T>): Boolean {
        var modified = false
        for (o in t)
            if (remove(o))
                modified = true
        return modified
    }

    override fun clear() {
        map.clear()
    }

    override fun toString(): String {
        return map.keys.joinToString(separator = " ")
    }

    operator fun plus(t: MySetImpl<T>): MySetImpl<T> {
        val result: MySetImpl<T> = MySetImpl()
        result.addAll(map.keys)
        result.addAll(t.map.keys)
        return result
    }

    operator fun minus(t: MySetImpl<T>): MySetImpl<T> {
        val result: MySetImpl<T> = MySetImpl()
        result.addAll(map.keys)
        result.removeAll(t.map.keys)
        return result
    }

    override fun iterator(): Iterator<T> {
        return IteratorImpl()
    }

    private inner class IteratorImpl : Iterator<T> {
        var index = 0

        override fun hasNext(): Boolean = index < size()

        override fun next(): T {
            if (!hasNext()) throw NoSuchElementException()
            return map.keys.elementAt(index++)
        }
    }
}

fun <T, R> MySet<T>.map(transform: (T) -> R): List<R> {
    val newList: ArrayList<R> = ArrayList()
    this.forEach {
        newList.add(transform(it))
    }
    return newList
}

fun <T> MySet<T>.filter(condition: (T) -> Boolean): List<T> {
    val newList: ArrayList<T> = ArrayList()
    this.forEach {
        if (condition(it))
            newList.add(it)
    }
    return newList
}