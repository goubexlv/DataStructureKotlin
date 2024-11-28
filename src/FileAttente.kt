

class Queue<T> {
    private val elements: MutableList<T> = mutableListOf()

    fun enqueue(item: T) {
        elements.add(item)
    }

    fun dequeue(): T? {
        if(isEmpty()){
            return null
        }
        return elements.removeAt(0)
    }

    fun peek(): T? {
        return elements.firstOrNull()
    }

    fun isEmpty() = elements.isEmpty()

}

fun main(){
    val queue = Queue<Int>()
    queue.enqueue(1)
    queue.enqueue(2)
    queue.enqueue(3)
    println(queue.peek())
    println(queue.dequeue())
    println(queue.peek())
}