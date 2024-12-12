class Node(val data: Int) {
    var left: Node? = null
    var right: Node? = null
}

class BinaryTree {
    var root: Node? = null

    fun insert(value: Int) {
        root = insertRecursive(root, value)
    }

    private fun insertRecursive(current: Node?, value: Int): Node {
        if (current == null) {
            return Node(value)
        }
        if (value < current.data) {
            current.left = insertRecursive(current.left, value)
        } else if (value > current.data) {
            current.right = insertRecursive(current.rght, value)
        }
        return current
    }

    fun search(value: Int) : Boolean {
        return searchRecursive(root, value)
    }

    private fun searchRecursive(current: Node?, value: Int): Boolean{
        if (current == null) {
            return false
        }
        if (value == current.data) {
            return true
        }
        return if (value < current.data) {
            searchRecursive(current.left, value)
        } else {
            searchRecursive(current.right, value)
        }
    }

    fun delete(value: Int) {
        root = deleteRecursive(root, value)
    }

    private fun deleteRecursive(current: Node?, value: Int): Node{
        if (current == null) {
            return null
        }
        if (value == current.data) {
            if (current.left == null && current.right == null) {
                return null
            }
            if (current.right == null) {
                return current.left
            }
            if(current.left == null) {
                return current.right
            }
            val smallestValue = findSmallestValue(current.right!!)
            current.data = smallestValue
            current.right = deleteRecursive(current.right, smallestValue)
            return current
        }
        if (value < current.data) {
            current.left = deleteRecursive(current.left, value)
            return current
        }
        current.right = deleteRecursive(current.right, value)
        return current
    }

    private fun findSmallestValue(root: Node): Int {
        return if (root.left == null) {
            root.data
        } else {
            findSmallestValue(root.left!!)
        }
    }

    fun preOrderTraversal(node: Node?) {
        if (node != null) {
            println(node.data)
            preOrderTraversal(node.left)
            preOrderTraversal(node.right)
        }
    }

    fun inOrderTraversal(node: Node?) {
        if (node != null) {
            inOrderTraversal(node.left)
            println(node.data)
            inOrderTraversal(node.right)
        }
    }

    fun postOrderTraversal(node: Node?) {
        if (node != null) {
            postOrderTraversal(node.left)
            postOrderTraversal(node.right)
            println(node.data)
        }
    }

}

fun main() {
    val tree = BinaryTree()
    tree.insert(6)
    tree.insert(4)
    tree.insert(8)
    tree.insert(3)
    tree.insert(5)
    tree.insert(7)
    tree.insert(9)
    println("Pre-order traversal:")
    tree.preOrderTraversal(tree.root)
    println("\nIn-order traversal:")
    tree.inOrderTraversal(tree.root)
    println("\nPost-order traversal:")
    tree.postOrderTraversal(tree.root)
    println("\nSearch for 5: ${tree.search(5)}")
    println("Search for 10: ${tree.search(10)}")
    tree.delete(5)
    println("\nIn-order traversal after deleting 5:")
    tree.inOrderTraversal(tree.root)
}