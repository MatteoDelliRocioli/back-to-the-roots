package delli.interfaces;

import delli.classes.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public interface BinaryTreeDataStructure {
  void addChild(int value);
  void addChild(int value, Node current);
  void removeChild(int value);
  Node removeChild(int value, Node current, Node parent);
  Node findNode(int value, Node current);
  Node findNode(int value);

  List<Integer> dfsSearchPreOrder();
  List<Integer> dfsSearchPostOrder();
  List<Integer> dfsSearchInOrder();
  List<Integer> dfsSearchPreOrder(Node current);
  List<Integer> dfsSearchPostOrder(Node current);
  List<Integer> dfsSearchInOrder(Node current);
  List<Integer> bfsSearch();
  List<Integer> bfsSearch(
      Node current, Queue<Node> queue, List<Integer> result);
}
