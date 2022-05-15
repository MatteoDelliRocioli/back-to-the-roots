package delli;

import javax.swing.tree.TreeNode;

public class Main {

  public static void main(String[] args) {
    Main main = new Main();
    main.solve();
  }

  public void solve() {
    maxDepth(new TreeNode());
  }

  int maxDepth = 0;
  public int maxDepth(TreeNode root) {
    helper(root, maxDepth + 1);

    return maxDepth;
  }

  // DFS max depth -> preorder traversal
  public void helper(TreeNode root, int depth) {
    if (root == null) {
      return;
    }

    if (root.left == null && root.right == null) {
      maxDepth = Math.max(maxDepth, depth);
    }

    helper(root.left, depth + 1);
    helper(root.right, depth + 1);
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
