
data class PQEelement<T>(val data: T, val priority: Int)
class PriorityQueue<T> {
    private val elements: MutableList<PQEelement<T>> = mutableListOf()


    fun enqueue(item: T, priority: Int){
        val pqElement = PQEelement(item, priority)
        elements.add(pqElement)
        elements.sortByDescending { it.priority }
    }

    fun dequeue(): T? {
        if (isEmpty()) {
            return null
        }
        return elements.removeAt(0).data
    }

    fun peek(): T? {
        return elements.firstOrNull()?.data
    }

    fun isEmpty() = elements.isEmpty()

}

fun main(){
    val pq = PriorityQueue<String>()
    pq.enqueue("Task 1",2)
    pq.enqueue("Task 2",1)
    pq.enqueue("Task 3",3)
    println(pq.peek())
    println(pq.dequeue())
    println(pq.peek())
}