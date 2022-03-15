#pragma once
#include <iostream>
#include <vector>

class Graph {
  public:
    int numberOfEdges {0};
    int numberOfNodes {0};
    std::vector<std::pair<int, int>> edgeList {};

    Graph();
    ~Graph();
    void AddVertex(int vertexValue);
    //Undirected graph
    void AddEdge(int valueVertex1, int valueVertex2);
    void PrintConnections();
};