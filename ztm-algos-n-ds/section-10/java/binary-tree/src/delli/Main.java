package delli;

import delli.classes.BinaryTree;
import delli.interfaces.BinaryTreeDataStructure;

public class Main {

  /**
  * A binary search tree is a tree structure where each node has between
  * zero and two children, the right child is greater then the parent and
  * the left child is smaller
  */

  public static void main(String[] args) {
  // write your code here
    BinaryTreeDataStructure tree = new BinaryTree(50);

    tree.findNode(10);

    tree.addChild(10);
    tree.addChild(1);
    tree.addChild(2);
    tree.addChild(60);
    tree.addChild(70);

    tree.findNode(70);
  }
}
