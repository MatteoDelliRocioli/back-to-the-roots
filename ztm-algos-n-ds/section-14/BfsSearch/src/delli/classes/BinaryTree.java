package delli.classes;

import delli.interfaces.BinaryTreeDataStructure;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTree implements BinaryTreeDataStructure {
  /*
  void Remove(int data, Node* current = NULL, Node* parent = NULL);*/
  Node root = null;
  public BinaryTree(int rootValue) {
    root = new Node(rootValue);
  }

  public void addChild(int value) {
    addChild(value, null);
  }

  public void addChild(int value, Node current) {
    if (current == null) {
      System.out.println(String.format("adding value: %d", value));
      current = root;
    }

    Node left = current.children[0];
    Node right = current.children[1];

    if (left == null && value < current.value) {
      //add left
      current.children[0] = new Node(value);
      return;
    }

    if (right == null && value > current.value) {
      //add right
      current.children[1] = new Node(value);
      return;
    }

    if (left != null && value < current.value) {
      //go left
      addChild(value, left);
      return;
    }

    if (right != null && value > current.value) {
      //go right
      addChild(value, right);
      return;
    }
  }

  public void removeChild(int value) {
    System.out.println(String.format("removing value: %d",value));
    removeChild(value, null, null);
  }

  private int pickSmallestValue(Node current) {
    if (current.children[0] != null) {
      return pickSmallestValue(current.children[0]);
    }
    return current.value;
  }

  public Node removeChild(int value, Node current, Node parent) {
    if (current == null) {
      System.out.println(String.format("removing value: %d",value));
      current = parent = root;
    }

    Node left = current.children[0];
    Node right = current.children[1];

    if (current.value == value && left == null && right == null) {
      if (parent.children[0] == current) {
        parent.children[0] = null;
      }
      else {
        parent.children[1] = null;
      }
      current = null;
      return current;
    }

    //left branched
    if (current.value == value && left != null && right == null) {
      parent.children[0] = left;
      current = null;
      return current;
    }

    //right branched
    if (current.value == value && right != null && left == null) {
      parent.children[1] = right;
      current = null;
      return current;
    }

    // both branches
    if (current.value == value && left != null && right != null) {
      // pick the node with the smallest value in the right branch and swap it
      // with current then you can delete the smallest node from its original
      // position

      // take smallest
      int min = pickSmallestValue(current.children[1]);
      // swap values
      current.value = min;
      // delete smallest, root is swapped node -> right
      return removeChild(min, current.children[1], current.children[1]);
    }

    if (left != null && value < current.value) {
      return removeChild(value, left, current);
    }

    if (right != null && value > current.value) {
      return removeChild(value, right, current);
    }

    return current;
  }

  private int minValue(Node node) {

    if(node.children[0] != null) {
      return minValue(node.children[0]);
    }
    return node.value;
  }

  public Node findNode(int value) {
    return findNode(value, null);
  }

  public Node findNode(int value, Node current) {
    if (current == null) {
      current = root;
    }

    //node found
    if (current.value == value) {
      System.out.println(String.format("found node with value: %d", value));
      return current;
    }

    Node left = current.children[0];
    Node right = current.children[1];

    //if leaf
//    if (left == null && right == null) {
//      System.out.println(String.format("no node found with value: %d", value));
//      return null;
//    }

    //do we go left or right?
    if (left != null && value < current.value) {
      //go left
      return findNode(value, left);
    }

    if (right != null && value > current.value) {
      //go right
      return findNode(value, right);
    }

    System.out.println(String.format("no node found with value: %d", value));
    return null;
  }

  //DFS

  public List<Integer> dfsSearchPreOrder() {
    return dfsSearchPreOrder(root);
  }

  public List<Integer> dfsSearchPreOrder(Node current) {
    if (current == null) {
      return null;
    }

    List<Integer> result = new ArrayList<>();
    result.add(current.value);

    if (current.children[0] != null) {
      List<Integer> temp = dfsSearchPreOrder(current.children[0]);
      if (temp != null && !temp.isEmpty()) {
        result.addAll(temp);
      }
    }

    if (current.children[1] != null) {
      List<Integer> temp = dfsSearchPreOrder(current.children[1]);
      if (temp != null && !temp.isEmpty()) {
        result.addAll(temp);
      }
    }

    return result;
  }

  public List<Integer> dfsSearchPostOrder() {
    return dfsSearchPostOrder(root);
  }

  public List<Integer> dfsSearchPostOrder(Node current) {
    if (current == null) {
      return null;
    }

    List<Integer> result = new ArrayList<>();

    if (current.children[0] != null) {
      List<Integer> temp = dfsSearchPostOrder(current.children[0]);
      if (temp != null && !temp.isEmpty()) {
        result.addAll(temp);
      }
    }

    if (current.children[1] != null) {
      List<Integer> temp = dfsSearchPostOrder(current.children[1]);
      if (temp != null && !temp.isEmpty()) {
        result.addAll(temp);
      }
    }

    result.add(current.value);

    return result;
  }

  public List<Integer> dfsSearchInOrder() {
    return dfsSearchInOrder(root);
  }

  public List<Integer> dfsSearchInOrder(Node current) {
    if (current == null) {
      return null;
    }

    List<Integer> result = new ArrayList<>();

    if (current.children[0] != null) {
      List<Integer> temp = dfsSearchInOrder(current.children[0]);
      if (temp != null && !temp.isEmpty()) {
        result.addAll(temp);
      }
    }

    result.add(current.value);

    if (current.children[1] != null) {
      List<Integer> temp = dfsSearchInOrder(current.children[1]);
      if (temp != null && !temp.isEmpty()) {
        result.addAll(temp);
      }
    }

    return result;
  }

  //BFS
  public List<Integer> bfsSearch() {
    Queue<Node> queue = new LinkedList<>();
    List<Integer> result = new ArrayList<>();
    queue.add(root);
    return bfsSearch(root, queue, result);
  }

  public List<Integer> bfsSearch(
      Node current, Queue<Node> queue, List<Integer> result) {
    //for each level, we check for children
    // we add those children to the queue

    if (!queue.isEmpty()) {
      Node first = queue.remove();

      if (first.children[0] != null) {
        queue.add(first.children[0]);
      }
      if (first.children[1] != null) {
        queue.add(first.children[1]);
      }
      result.add(first.value);
      return bfsSearch(queue.peek(), queue, result);
    }

    return result;
  }
}
