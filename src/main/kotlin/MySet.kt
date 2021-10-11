interface MySet<T> {

    fun isEmpty(): Boolean

    fun contains(t: T): Boolean

    fun size(): Int

    fun add(t: T): Boolean

    fun remove(t: T): Boolean

    fun addAll(t: Collection<T>): Boolean

    fun removeAll(t: Collection<T>): Boolean

    fun clear()
}
