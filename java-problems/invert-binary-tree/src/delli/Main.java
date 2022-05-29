package delli;

import javax.swing.tree.TreeNode;

public class Main {

  public static void main(String[] args) {
    Main main = new Main();
    main.invertTree(null);
  }

  public TreeNode invertTree(TreeNode root) {
    helper(root);
    return root;
  }

  /**
   * Recursive approach with DFS in post-order
   * each node should have its children swapped with bottom->up, left->right direction
   *
   * time complexity: O(n) since we will have to iterate through all the nodes
   * space complexity: O(h) where h is the height of the tree which is equal
   *  to the number of recursive calls in the call stack
   * */
  public void helper(TreeNode root) {
    if (root == null) {
      return;
    }

    helper(root.right);
    helper(root.left);

    TreeNode tmp = root.left;
    root.left = root.right;
    root.right = tmp;
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
