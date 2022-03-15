#pragma once
#include <iostream>
#include <vector>

class Graph {
  public:
    int numberOfEdges {0};
    int numberOfNodes {0};
    std::vector<char> nodesList {};
    std::vector<std::pair<char, char>> edgeList {};

    Graph();
    ~Graph();
    void AddVertex(char vertexValue);
    //Undirected graph
    void AddEdge(char valueVertex1, char valueVertex2);
    void PrintConnections();

  private:
    void PrintNodesList();
};