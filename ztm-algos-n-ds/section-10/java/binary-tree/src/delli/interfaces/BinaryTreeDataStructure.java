package delli.interfaces;

import delli.classes.Node;

public interface BinaryTreeDataStructure {
  void addChild(int value);
  void addChild(int value, Node current);
  void removeChild(int value);
  void removeChild(int value, Node current, Node parent);
  Node findNode(int value, Node current);
  Node findNode(int value);
}
