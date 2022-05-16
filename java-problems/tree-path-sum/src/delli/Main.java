package delli;

import javax.swing.tree.TreeNode;

public class Main {

  public static void main(String[] args) {
    Main main = new Main();
    main.helper();
  }

  public void helper() {
    hasPathSum(new TreeNode(), 22);
  }

  // recursive approach
  /**
   * time complexity: O(n), possibly iterating all the nodes
   * space complexity: O(h) where h is the maximum height of the tree
   * */
  public boolean hasPathSum(TreeNode root, int targetSum) {
    // recursive approach
    solve(root, targetSum, 0);

    return result;
  }

  boolean result = false;

  public void solve(TreeNode node, int targetSum, int currentSum) {

    if (node == null) {
      return;
    }

    if (node.left == null && node.right == null) {
      if ((currentSum + node.val) == targetSum) {
        result = true;
      }

      return;
    }

    if (node.left != null) {
      solve(node.left, targetSum, currentSum + node.val);
    }

    if (node.right != null) {
      solve(node.right, targetSum, currentSum + node.val);
    }
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
