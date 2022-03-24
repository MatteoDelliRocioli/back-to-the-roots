package delli.classes;

import delli.interfaces.BinaryTreeDataStructure;

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

  public void removeChild(int value, Node current, Node parent) {

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
      return;
    }

    //left branched
    if (current.value == value && left != null && right == null) {
      parent.children[0] = left;
      current = null;
      return;
    }

    //right branched
    if (current.value == value && right != null && left == null) {
      parent.children[1] = right;
      current = null;
      return;
    }

    // both branches
    if (current.value == value && left != null && right != null) {
      // pick the node with the smallest value in the right branch and swap it
      // with current then you can delete the smallest node from its original
      // position
      boolean foundSmallest = false;
      Node smallest = null;

      while(!foundSmallest ||
          (smallest.children[0] != null && smallest.children[1] != null)) {
        if (smallest == null) {
          smallest = current.children[1];
        }

        if (smallest.children[0] == null) {
          foundSmallest = true;
          continue;
        }

        smallest = smallest.children[0];
      }

      removeChild(value, current, current);
//      Node temp = smallest;
//      current.value = smallest.value;
//      smallest = null;
    }

    if (left != null && value < current.value) {
      removeChild(value, left, current);
      return;
    }

    if (right != null && value > current.value) {
      removeChild(value, right, current);
      return;
    }
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
