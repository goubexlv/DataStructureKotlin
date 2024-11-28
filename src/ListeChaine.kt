class Node<T>(var data: T, var next: Node<T>? = null)

class LinkedList<T>{
    private var head: Node<T>? = null

    fun append(data: T){
        if(head == null){
            head = Node(data)
            return
        }
        var current = head
        while(current?.next != null){
            current = current?.next
        }
        current?.next = Node(data)
    }

    fun prepend(data: T){
        val newHead = Node(data, head)
        head = newHead
    }

    fun deleteWithValue(data: T){
        if(head == null) return
        if(head?.data == data){
            head = head?.next
            return
        }
        var current = head
        while(current?.next != null && current.next?.data != data){
            current = current.next
        }
        current?.next = current?.next?.next
    }

    fun display(): List<T> {
        val result = mutableListOf<T>()
        var current = head
        while(current != null){
            result.add(current.data)
            current = current.next
        }
        return result
    }
}

fun main(){
    val ll = LinkedList<Int>()
    ll.append(1)
    ll.append(2)
    ll.append(3)
    ll.prepend(0)
    println(ll.display())  
    ll.deleteWithValue(2)
    println(ll.display())

}







