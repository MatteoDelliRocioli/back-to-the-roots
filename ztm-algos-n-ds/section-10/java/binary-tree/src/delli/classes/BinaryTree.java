package delli.classes;

import delli.interfaces.BinaryTreeDataStructure;

public class BinaryTree implements BinaryTreeDataStructure {
  /*public void Insert(int data, Node current);
  bool LookUp(int data, Node* current = NULL);
  void Remove(int data, Node* current = NULL, Node* parent = NULL);

  Node* root;

  private:
  int FindNodeWithSmallestData(Node* current, Node* parent);*/
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
}
