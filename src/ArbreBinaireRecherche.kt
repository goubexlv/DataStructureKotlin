// Define the Node class
class Node(var data: Int) {
    var left: Node? = null
    var right: Node? = null
}

class BinarySearchTree {
    var root: Node? = null

    // Insert data into the BST
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
            current.right = insertRecursive(current.right, value)
        }
        return current
    }

    
    fun search(value: Int): Boolean {
        return searchRecursive(root, value)
    }

    private fun searchRecursive(current: Node?, value: Int): Boolean {
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

    private fun deleteRecursive(current: Node?, value: Int): Node? {
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
            if (current.left == null) {
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
        return root.left?.let { findSmallestValue(it) } ?: root.data
    }


    fun findMin(): Int? {
        return findMinRecursive(root)
    }

    private fun findMinRecursive(node: Node?): Int? {
        return node?.left?.let { findMinRecursive(it) } ?: node?.data
    }


    fun findMax(): Int? {
        return findMaxRecursive(root)
    }

    private fun findMaxRecursive(node: Node?): Int? {
        return node?.right?.let { findMaxRecursive(it) } ?: node?.data
    }


    fun inOrderTraversal(node: Node?) {
        if (node != null) {
            inOrderTraversal(node.left)
            println(node.data)
            inOrderTraversal(node.right)
        }
    }

    fun preOrderTraversal(node: Node?) {
        if (node != null) {
            println(node.data)
            preOrderTraversal(node.left)
            preOrderTraversal(node.right)
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
    val bst = BinarySearchTree()
    bst.insert(50)
    bst.insert(30)
    bst.insert(70)
    bst.insert(20)
    bst.insert(40)
    bst.insert(60)
    bst.insert(80)
    println("In-order traversal:")
    bst.inOrderTraversal(bst.root)
    println("\nPre-order traversal:")
    bst.preOrderTraversal(bst.root)
    println("\nPost-order traversal:")
    bst.postOrderTraversal(bst.root)
    println("\nSearch for 40: ${bst.search(40)}")
    println("Search for 100: ${bst.search(100)}")
    println("\nMinimum value: ${bst.findMin()}")
    println("Maximum value: ${bst.findMax()}")
    bst.delete(40)
    println("\nAfter deleting 40:")
    bst.inOrderTraversal(bst.root)
    bst.delete(50)
    println("\nAfter deleting 50:")
    bst.inOrderTraversal(bst.root)
}