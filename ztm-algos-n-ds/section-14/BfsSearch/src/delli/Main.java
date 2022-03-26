package delli;

import delli.classes.BinaryTree;
import delli.interfaces.BinaryTreeDataStructure;

import java.util.List;

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
    tree.addChild(11);
    tree.addChild(1);
    tree.addChild(2);
    tree.addChild(60);
    tree.addChild(70);

//    tree.findNode(10);
//
//    tree.removeChild(10);
//
//    tree.findNode(10);

    String lineSeparator = System.lineSeparator();
    System.out.println(
      "    50" + lineSeparator +
      "   / \\" + lineSeparator +
      "  10 60" + lineSeparator +
      " / \\   \\" + lineSeparator +
      "1  11   70" + lineSeparator +
      " \\" + lineSeparator +
      "  2" + lineSeparator
    );


    List<Integer> result01 = tree.dfsSearch();
    for (int x : result01) {
      System.out.println(x);
    }

    System.out.println("//-------------------------------------------------//");

    List<Integer> result = tree.bfsSearch();
    for (int x : result) {
      System.out.println(x);
    }
  }
}
