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
    helper(root);

    return diameter;
  }

  public int helper(TreeNode root) {
    if (root == null) {
      return 0;
    }

    int leftHeight = helper(root.left);
    int rightHeight = helper(root.right);

    diameter = Math.max(diameter, (leftHeight + rightHeight));

    return Math.max(leftHeight, rightHeight) + 1;
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
