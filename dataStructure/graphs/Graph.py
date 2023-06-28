#graph 
#   
#   node 0 is connected to 2
#   node 1 is connected to 2, 3 
#   node 2 is connected to 0, 1 and 3
#   node 3 is connected to 1, 2
#
#
#
#
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

