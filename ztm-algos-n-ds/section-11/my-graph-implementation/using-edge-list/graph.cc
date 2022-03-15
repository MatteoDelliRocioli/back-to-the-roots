#include <iostream>
#include "graph.h"

Graph::Graph() {
  std::cout << "Created graph" << std::endl;
}

Graph::~Graph() {
  std::cout << "deleting graph" << std::endl;
}

void Graph::AddVertex(int value) {
  std::cout << "adding vertex with value: " << value << std::endl;
}

void Graph::AddEdge(int vertex1, int vertex2) {
  std::cout << "Adding edge between: " << vertex1 << ", " << vertex2 << std::endl;
}

void Graph::PrintConnections() {
  std::cout << "printing graph connections" << std::endl;
}