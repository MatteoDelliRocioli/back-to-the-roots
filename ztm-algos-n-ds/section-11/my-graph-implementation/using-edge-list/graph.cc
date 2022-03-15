#include <iostream>
#include <algorithm>
#include <vector>
#include "graph.h"

Graph::Graph() {
  std::cout << "Created graph" << std::endl;
}

Graph::~Graph() {
  std::cout << "deleting graph" << std::endl;
}

void Graph::AddVertex(char value) {
  std::cout << "adding vertex with value: " << value << std::endl;

  if (std::find(nodesList.begin(), nodesList.end(), value) == nodesList.end()) {
    nodesList.push_back(value);
  }
  PrintNodesList();
}

void Graph::AddEdge(char vertex1, char vertex2) {
  std::cout << "Adding edge between: " << vertex1 << ", " << vertex2 << std::endl;
}

void Graph::PrintConnections() {
  std::cout << "printing graph connections" << std::endl;
}

void Graph::PrintNodesList() {
  std::cout << "[ ";
  for (char x : nodesList) {
    std::cout << x << ", ";
  }
  std::cout << "]" << std::endl;
}