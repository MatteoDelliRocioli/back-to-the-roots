package delli.interfaces;

import delli.classes.Node;

import java.util.List;

public interface BinaryTreeDataStructure {
  void addChild(int value);
  void addChild(int value, Node current);
  void removeChild(int value);
  Node removeChild(int value, Node current, Node parent);
  Node findNode(int value, Node current);
  Node findNode(int value);

  List<Integer> dfsSearch();
  List<Integer> dfsSearch(Node current);
}
