class HashTable<K, V>(private val size: Int) {
    private val storage: Array<MutableList<Pair<K, V>>> = Array(size) { mutableListOf() }


    private fun hash(key: K): Int = key.hashCode() % size


    fun put(key: K, value: V) {
        val index = hash(key)
        storage[index].add(Pair(key, value))
    }


    fun get(key: K): V? {
        val index = hash(key)
        for (entry in storage[index]) {
            if (entry.first == key) {
                return entry.second
            }
        }
        return null
    }


    fun remove(key: K) {
        val index = hash(key)
        val iterator = storage[index].iterator()
        while (iterator.hasNext()) {
            if (iterator.next().first == key) {
                iterator.remove()
                return
            }
        }
    }
}


fun main() {
    val hashTable = HashTable<String, String>(10)
    hashTable.put("John", "Engineer")
    hashTable.put("Jane", "Doctor")
    hashTable.put("Mike", "Architect")
    println("John is an ${hashTable.get("John")}")
    println("Jane is an ${hashTable.get("Jane")}")
    hashTable.remove("Jane")
    println("After removing Jane: Jane is an ${hashTable.get("Jane")}")
}