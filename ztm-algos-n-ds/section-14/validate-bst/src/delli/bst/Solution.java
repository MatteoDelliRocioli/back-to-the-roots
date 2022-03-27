package delli.bst;

public class Solution {
  public boolean isValidBST(TreeNode root) {
    // current.val > current.left.val
    // current.val < current.right.val
    return helper(root, null, null);
  }

  //We can use DFS to solve this problem since we have to make sure that each
  // node in the tree is greater than its first parent if on the right side, and
  // must be lesser than its parent if on the left side

  // plus all the elements on the right subtree have to be greater than its root
  // and all the nodes from the left subtree have to be lesser than its root
  boolean helper(TreeNode root, Integer min, Integer max) {
    if (root == null)
      return true;

    if ((min != null && root.val <= min) || (max != null && root.val >= max))
      return false;

    return helper(root.left, min, root.val) && helper(root.right, root.val, max);
  }
}