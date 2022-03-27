package delli.bst;

public class Solution {
  public boolean isValidBST(TreeNode root) {
    // current.val > current.left.val
    // current.val < current.right.val
    if (root == null) {
      return false;
    }

    return iterateTree(root);
  }

  public boolean iterateTree(TreeNode current) {
    if (!isBST(current)) {
      return false;
    }

    if (current.left != null) {
      iterateTree(current.left);
    }

    if (current.right != null) {
      iterateTree(current.right);
    }

    return true;
  }

  public boolean isBST(TreeNode current) {
    if (current == null) {
      return false;
    }

    if (current.left != null && current.val < current.left.val) {
      return false;
    }

    if (current.right != null && current.val > current.right.val) {
      return false;
    }

    if (current.left != null && current.val == current.left.val) {
      return false;
    }

    if (current.right != null && current.val == current.right.val) {
      return false;
    }

    return true;
  }
}