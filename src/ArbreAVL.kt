class Node(var key: Int) {
    var height: Int = 1
    var left: Node? = null
    var right: Node? = null
}

class AVLTree {
    private fun height(node: Node?): Int {
        return node?.height ?: 0
    }

    private fun updateHeight(node: Node) {
        node.height = 1 + maxOf(height(node.left), height(node.right))
    }

    private fun balanceFactor(node: Node?): Int {
        return height(node?.left) - height(node?.right)
    }

    private fun leftRotate(x: Node): Node {
        val y = x.right!!
        val T2 = y.left
        y.left = x
        x.right = T2
        updateHeight(x)
        updateHeight(y)
        return y
    }

    private fun rightRotate(y: Node): Node {
        val x = y.left!!
        val T2 = x.right
        x.right = y
        y.left = T2
        updateHeight(y)
        updateHeight(x)
        return x
    }

    fun insert(root: Node?, key: Int): Node {
        if (root == null) return Node(key)
        if (key < root.key) root.left = insert(root.left, key)
        else if (key > root.key) root.right = insert(root.right, key)
        else return root
        updateHeight(root)
        val balance = balanceFactor(root)
        if (balance > 1) {
            if (key < root.left!!.key) {
                return rightRotate(root)
            } else {
                root.left = leftRotate(root.left!!)
                return rightRotate(root)
            }
        }
        if (balance < -1) {
            if (key > root.right!!.key) {
                return leftRotate(root)
            } else {
                root.right = rightRotate(root.right!!)
                return leftRotate(root)
            }
        }
        return root
    }

    fun delete(root: Node?, key: Int): Node? {
        if (root == null) return root
        if (key < root.key) {
            root.left = delete(root.left, key)
        } else if (key > root.key) {
            root.right = delete(root.right, key)
        } else {
            if (root.left == null || root.right == null) {
                var temp: Node? = null
                temp = root.left ?: root.right
                if (temp == null) {
                    temp = root
                    root = null
                } else {
                    root = temp
                }
            } else {
                val temp = minValueNode(root.right!!)
                root.key = temp.key
                root.right = delete(root.right, temp.key)
            }
        }
        if (root == null) return root
        updateHeight(root)
        val balance = balanceFactor(root)
        if (balance > 1) {
            if (balanceFactor(root.left) >= 0) {
                return rightRotate(root)
            } else {
                root.left = leftRotate(root.left!!)
                return rightRotate(root)
            }
        }
        if (balance < -1) {
            if (balanceFactor(root.right) <= 0) {
                return leftRotate(root)
            } else {
                root.right = rightRotate(root.right!!)
                return leftRotate(root)
            }
        }
        return root
    }

    private fun minValueNode(node: Node): Node {
        var current = node
        while (current.left != null) current = current.left!!
        return current
    }

    fun preOrder(root: Node?) {
        if (root != null) {
            println(root.key)
            preOrder(root.left)
            preOrder(root.right)
        }
    }
}

// client code to test AVL Tree Implementation in Kotlin
fun main() {
    var tree: Node? = null
    val avlTree = AVLTree()
    tree = avlTree.insert(tree, 10)
    tree = avlTree.insert(tree, 20)
    tree = avlTree.insert(tree, 30)
    tree = avlTree.insert(tree, 40)
    tree = avlTree.insert(tree, 50)
    tree = avlTree.insert(tree, 25)
    println("Preorder traversal of constructed AVL tree:")
    avlTree.preOrder(tree)
    tree = avlTree.delete(tree, 10)
    println("\nPreorder traversal after deleting 10:")
    avlTree.preOrder(tree)
}