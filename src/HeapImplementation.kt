class Heap(private val isMinHeap: Boolean = true) {
    private val list = mutableListOf<Int>()

    private fun parent(index: Int) = (index - 1) / 2

    private fun leftChild(index: Int) = 2 * index + 1

    private fun rightChild(index: Int) = 2 * index + 2

    private fun compare(i: Int, j: Int) = if (isMinHeap) list[i] < list[j] else list[i] > list[j]
    fun add(value: Int) {
        list.add(value)
        var currentIndex = list.size - 1
        while (currentIndex > 0 && compare(currentIndex, parent(currentIndex))) {
            val temp = list[currentIndex]
            list[currentIndex] = list[parent(currentIndex)]
            list[parent(currentIndex)] = temp
            currentIndex = parent(currentIndex)
        }
    }

    fun removePeak(): Int {
        if (list.isEmpty()) throw NoSuchElementException("Heap is empty")
        val peak = list[0]
        val lastValue = list.removeAt(list.size - 1)
        if (list.isNotEmpty()) {
            list[0] = lastValue
            heapify(0)
        }
        return peak
    }

    private fun heapify(index: Int) {
        val left = leftChild(index)
        val right = rightChild(index)
        var largestOrSmallest = index
        if (left < list.size && compare(left, index)) largestOrSmallest = left
        if (right < list.size && compare(right, largestOrSmallest)) largestOrSmallest = right
        if (largestOrSmallest != index) {
            val temp = list[index]
            list[index] = list[largestOrSmallest]
            list[largestOrSmallest] = temp
            heapify(largestOrSmallest)
        }
    }

    fun display() {
        println(list)
    }

}


fun main() {
    val minHeap = Heap()
    val maxHeap = Heap(isMinHeap = false)
    listOf(5, 3, 8, 1, 4).forEach {
        minHeap.add(it)
        maxHeap.add(it)
    }
    minHeap.display()
    maxHeap.display()
    println("Min peak: ${minHeap.removePeak()}")
    println("Max peak: ${maxHeap.removePeak()}")
    minHeap.display()
    maxHeap.display()
}