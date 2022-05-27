package delli;

import javax.swing.tree.TreeNode;

public class Main {

  /**
   * https://leetcode.com/problems/diameter-of-binary-tree/
   */
  public static void main(String[] args) {
  }

  int diameter = 0;

  public int diameterOfBinaryTree(TreeNode root) {
    if (root == null) {
      return 0;
    }

    traverse(root);

    return diameter;
  }

  public int traverse(TreeNode root) {
    if (root == null) {
      return 0;
    }

    int left = traverse(root.left);
    int right = traverse(root.right);

    diameter = Math.max(diameter, left + right);

    return Math.max(left, right) + 1;
  }

  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
}
