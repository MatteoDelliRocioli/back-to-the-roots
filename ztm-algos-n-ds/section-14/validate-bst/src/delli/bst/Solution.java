package delli.bst;

public class Solution {
  public boolean isValidBST(TreeNode root) {
    // current.val > current.left.val
    // current.val < current.right.val
    if (root == null) {
      return true;
    }

    if (root.left != null && root.left.val == root.val) {
      return false;
    }

    if (root.right != null && root.right.val == root.val) {
      return false;
    }

    return check(root);
  }

  //We can use DFS to solve this problem since we have to make sure that each
  // node in the tree is greater than its first parent if on the right side, and
  // must be lesser than its parent if on the left side

  // plus all the elements on the right subtree have to be greater than its root
  // and all the nodes from the left subtree have to be lesser than its root

  public boolean check(TreeNode root) {

    int upperBound = Integer.MAX_VALUE;
    int lowerBound = Integer.MIN_VALUE;

    if (root.left != null) {
      boolean result = checkLeft(root.left, root.val, lowerBound);

      if (!result) {
        return result;
      }
    }

    if (root.right != null) {
      return checkRight(root.right, upperBound, root.val);
    }

    return true;
  }

  public boolean checkLeft(TreeNode root, int upperBound, int lowerBound) {
    //always update upperbound
    if (root.left != null && root.right != null) {
      upperBound = root.val;
    }
    if (root.left != null) {
      if (root.left.val == root.val) {
        return false;
      }

      if (root.left.val < upperBound && root.left.val > lowerBound) {
        //ok, keep searching
        checkLeft(root.left, upperBound, lowerBound);
      }
      else {
        return false;
      }
    }

    //if go right than update lowerbound
    if (root.right != null) {
      lowerBound = root.val;

      if (root.right.val == root.val) {
        return false;
      }
      if (root.right.val < upperBound && root.right.val > lowerBound) {
        //ok keep searching
        checkLeft(root.right, upperBound, lowerBound);
      }
      else {
        return false;
      }
    }

    return true;
  }

  public boolean checkRight(TreeNode root, int upperBound, int lowerBound) {
    //lowerBound has to be updated always
    if (root.left != null && root.right != null) {
      lowerBound = root.val;
    }
    if (root.right != null) {
      if (root.left.val == root.val) {
        return false;
      }
      if (root.right.val > lowerBound && root.right.val < upperBound) {
        //good, keep searching
        checkRight(root.right, upperBound, lowerBound);
      }
      else {
        return false;
      }
    }

    if (root.left != null) {
      upperBound = root.val;
      if (root.right.val == root.val) {
        return false;
      }
      if (root.left.val > lowerBound && root.left.val < upperBound) {
        //ok, keep searching
        checkRight(root.right, upperBound, lowerBound);
      }
      else {
        return false;
      }
    }

    return true;
  }

}