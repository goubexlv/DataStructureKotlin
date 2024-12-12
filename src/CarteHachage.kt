class HashMap<K, V> {
    private data class Entry<K, V>(val key: K, var value: V) {
        var next: Entry<K, V>? = null
    }
    private val capacity = 16
    private val table = arrayOfNulls<Entry<K, V>>(capacity)
    private var size = 0

    private fun hash(key: K): Int = (key.hashCode() and Int.MAX_VALUE) % capacity
    fun put(key: K, value: V): V? {
        val index = hash(key)
        var existing = table[index]
        while (existing != null) {
            if (existing.key == key) {
                val oldValue = existing.value
                existing.value = value
                return oldValue
            }
            existing = existing.next
        }
        val entry = Entry(key, value)
        entry.next = table[index]
        table[index] = entry
        size++
        return null
    }
    fun get(key: K): V? {
        var current = table[hash(key)]
        while (current != null) {
            if (current.key == key) {
                return current.value
            }
            current = current.next
        }
        return null
    }
    fun remove(key: K): V? {
        val index = hash(key)
        var prev: Entry<K, V>? = null
        var current = table[index]
        while (current != null) {
            if (current.key == key) {
                if (prev == null) {
                    table[index] = current.next
                } else {
                    prev.next = current.next
                }
                size--
                return current.value
            }
            prev = current
            current = current.next
        }
        return null
    }
    fun size(): Int = size
}
fun main() {
    val hashMap = HashMap<String, Int>()
    hashMap.put("One", 1)
    hashMap.put("Two", 2)
    hashMap.put("Three", 3)
    println("Size of map: ${hashMap.size()}")
    println("Value of 'Two': ${hashMap.get("Two")}")
    hashMap.remove("Two")
    println("Size after removal: ${hashMap.size()}")
    println("Value of 'Two' after removal: ${hashMap.get("Two")}")
}