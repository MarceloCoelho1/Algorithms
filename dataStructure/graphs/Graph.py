#graph 
#   
#   node 0 is connected to 2
#   node 1 is connected to 2, 3 
#   node 2 is connected to 0, 1 and 3
#   node 3 is connected to 1, 2
#


# Edge list
graph = [[0, 2], [2, 3], [2, 1], [1, 3]]

#adjacent list
graph = [[2], [2, 3], [0, 1, 3], [1, 2]]

#adjacent matrix
graph = {
    0:[0, 0, 1, 0],
    1:[0, 0, 1, 1],
    2:[1, 1, 0 ,1],
    3:[0, 1, 1, 0]
}


#example
class Graph: 

    def __init__(self):
        self.numberOfNodes = 0
        self.adjacentList = {}

    def addVertex(self, node):
        self.adjacentList[node] = []
        self.numberOfNodes += 1

    #undirected graph
    def addEdges(self, node1, node2):
        self.adjacentList[node1].append(node2)
        self.adjacentList[node2].append(node1)
        


myGraph = Graph()
myGraph.addVertex(0)
myGraph.addVertex(1)
myGraph.addVertex(2)
myGraph.addVertex(3)
myGraph.addVertex(4)
myGraph.addVertex(5)
myGraph.addVertex(6)

myGraph.addEdges(3, 1)
myGraph.addEdges(3, 4)
myGraph.addEdges(4, 2)
myGraph.addEdges(4, 5)
myGraph.addEdges(1, 2)
myGraph.addEdges(1, 0)
