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

  if (!IsExistingNode(value)) {
    nodesList.push_back(value);
  }
  PrintNodesList();
}

void Graph::AddEdge(char vertex1, char vertex2) {
  std::cout << "Adding edge between: " << vertex1 << ", " << vertex2 <<
    std::endl;

  if (!IsExistingNode(vertex1) || !IsExistingNode(vertex2)) {
    std::cout << "Either " << vertex1 << " or " << vertex2 <<
      " are not present in this graph" << std::endl;
    return;
  }

  auto pair = std::make_pair(vertex1, vertex2);

  edgeList.push_back(pair);
  PrintEdgeList();
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

bool Graph::IsExistingNode(char value) {
  return std::find(nodesList.begin(), nodesList.end(), value) !=
    nodesList.end();
}

void Graph::PrintEdgeList() {
  std::cout << "[ ";
  for (auto x : edgeList) {
    std::cout << "(" << x.first << ", " << x.second << "), ";
  }
  std::cout << "]" << std::endl;
}