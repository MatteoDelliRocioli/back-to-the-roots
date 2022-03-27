package delli;

import delli.bst.Solution;
import delli.bst.Tree;
import delli.bst.TreeNode;

/**
 * Solution to https://leetcode.com/problems/validate-binary-search-tree/
 *
 * A valid BST is defined as follows:
 *
 *   The left subtree of a node contains only nodes with keys less than the node's key.
 *   The right subtree of a node contains only nodes with keys greater than the node's key.
 *   Both the left and right subtrees must also be binary search trees.
 * */
public class Main {

  public static void main(String[] args) {

//    Tree tree = new Tree(50);
    Tree tree = new Tree(5);

//    tree.root.left = new TreeNode(70);
//    tree.root.right = new TreeNode(10);

//    tree.addNode(10);
//    tree.addNode(11);
//    tree.addNode(1);
//    tree.addNode(2);
//    tree.addNode(60);
//    tree.addNode(70);

//    tree.root.left = new TreeNode(4);
//    tree.root.right = new TreeNode(6);
//    tree.root.right.left = new TreeNode(3);
//    tree.root.right.right = new TreeNode(7);

    tree.root.right = new TreeNode(-1);

    Solution solution = new Solution();
    boolean result = solution.isValidBST(tree.root);

    System.out.println(result);
  }
}
