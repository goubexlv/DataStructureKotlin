

class Stack<T>{
    private val elements: MutableList<T> = mutableListOf()

    fun push(item: T) {
        elements.add(item)
    }

    fun pop(): T? {
        if (isEmpty()) {
            return null
        }
        return elements.removeAt(elements.size -1)
    }

    fun peek() : T?{
        return elements.lastOrNull()
    }

    fun isEmpty() = elements.isEmpty()

}

fun main() {

    val stack = Stack<Int>()
    stack.push(1)
    stack.push(2)
    stack.push(3)
    println(stack.peek())
    println(stack.pop())
    println(stack.peek())
}