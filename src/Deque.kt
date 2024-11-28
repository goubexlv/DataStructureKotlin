
class Deque<T> {
    private val elements: MutableList<T> = mutableListOf()

    fun addFront(item: T) {
        elements.add(0,item)
    }

    fun addRear(item: T){
        elements.add(item)
    }

    fun removeFront() : T? {
        if (isEmpty()){
            return null
        }
        return elements.removeAt(0)
    }

    fun removeRear(): T? {
        if (isEmpty()){
            return null
        }
        return elements.removeAt(elements.size -1)
    }

    fun peekFront(): T? {
        return elements.firstOrNull()
    }

    fun peekRear(): T?{
        return elements.lastOrNull()
    }

    fun isEmpty() = elements.isEmpty()

}

fun main() {

    val deque = Deque<Int>()
    deque.addRear(1)
    deque.addRear(2)
    deque.addFront(0)
    println(deque.peekFront()) 
    println(deque.peekRear())
    println(deque.removeFront())
    println(deque.removeRear())
}