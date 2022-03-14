#pragma once
#include <iostream>
#include <vector>

class Graph {
  public:
    int numberOfNodes {0};
    std::vector<std::pair<int, int>> edgeList {};

    Graph();
    ~Graph();
    void addVertex(vertexValue);
    void addEdge(valueVertex1, valueVertex2);
    void printConnections();
};