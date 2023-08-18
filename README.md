# UberIT
 Application for optimising delivery tours in Lyon city.

# Algorithm
A courier starts out from the warehouse to deliver the goods on time, then returns to the warehouse. The aim of the algorithm is to find the optimal route. To do this, we first use Dijkstra's algorithm to calculate the shortest distance and route between two points, a priority queue data structure being particularly well suited to implementing this algorithm. Then, for each courier, the classic travelling salesman problem (TSP) arises. To find an exact solution, the Branch and Bound strategy is a good solution, and we can use various heuristic functions to improve the program's efficiency. For example, if there are three unvisited points, we can choose the two shortest paths between them, MST (Kruskal) is more precise... What's more, we've also added an order of passage for the iterator: we always start with the point having the minimum distance.
