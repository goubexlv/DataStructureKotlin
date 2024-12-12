class Graph {
    private val adjList: HashMap<Int, MutableList<Int>> = HashMap()

    fun addVertex(vertex: Int) {
        if (!adjList.containsKey(vertex)) adjList[vertex] = mutableListOf()
    }

    fun addEdge(v1: Int, v2: Int) {
        adjList[v1]?.add(v2)
        adjList[v2]?.add(v1)
    }

    fun removeVertex(vertex: Int) {
        while (adjList[vertex]?.isNotEmpty() == true) {
            val adjacentVertex = adjList[vertex]?.first()
            removeEdge(vertex, adjacentVertex!!)
        }
        adjList.remove(vertex)
    }

    fun removeEdge(v1: Int, v2: Int) {
        adjList[v1]?.remove(v2)
        adjList[v2]?.remove(v1)
    }

    fun display() {
        for ((vertex, edges) in adjList) {
            println("$vertex -> $edges")
        }
    }
}

fun main() {
    val graph = Graph()
    graph.addVertex(1)
    graph.addVertex(2)
    graph.addVertex(3)
    graph.addVertex(4)
    graph.addEdge(1, 2)
    graph.addEdge(1, 3)
    graph.addEdge(2, 4)
    graph.addEdge(3, 4)
    graph.display()
    graph.removeEdge(2, 4)
    graph.removeVertex(3)
    graph.display()
}