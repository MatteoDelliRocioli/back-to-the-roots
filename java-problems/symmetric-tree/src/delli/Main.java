package delli;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class Main {

  public static void main(String[] args) {

  }

  /**
   * recursive approach where we compare each node to its counterpart in the other
   * subtree
   *
   * time complexity: O(n) because we will have to iterate through all the nodes
   * space complexity: O(h) where h is the depth of one of the two subtrees or
   * the smallest one if they are different in size
   * */
  public boolean isSymmetric(TreeNode root) {
    return solve(root, root);
  }

  public boolean solve(TreeNode left, TreeNode right) {
    if (left == null && right == null) { // the two nodes are identical, true
      return true;
    }

    if (left == null || right == null) { // if we got here it means that only one of the two is null
      return false;
    }

    return left.val == right.val &&  // both values of the current nodes have to be equal
        solve(left.left, right.right) && // as well as their children
        solve(left.right, right.left);
  }

  /**
   * Solve by using BFS and comparing each level but one in reverse order
   * time complexity: O(n^2)
   * space complexity: O(n + m)
   * */
  /*public boolean isSymmetric(TreeNode root) {
    List<List<Integer>> leftResult = new ArrayList<>();
    List<List<Integer>> rightResult = new ArrayList<>();

    populateList(leftResult, root.left, 0);
    populateList(rightResult, root.right, 0);

    if (leftResult.size() != rightResult.size()) {
      return false;
    }

    //check both lists
    for (int i = 0; i < leftResult.size(); i++) {
      List<Integer> leftLevel = leftResult.get(i);
      List<Integer> rightLevel = rightResult.get(i);

      if (leftLevel.size() != rightLevel.size()) {
        return false;
      }

      for (int j = 0, x = rightLevel.size() - 1; j < leftLevel.size() && x >= 0; j++, x--) {
        if (leftLevel.get(j) != rightLevel.get(x)) {
          return false;
        }
      }
    }
    return true;
  }

  public void populateList(List<List<Integer>> result, TreeNode node, int level) {
    if (result.size() == level) {
      result.add(new ArrayList<Integer>());
    }

    result.get(level).add(node.val);

    if (node.left != null) {
      populateList(result, node.left, level + 1);
    }

    if (node.right != null) {
      populateList(result, node.right, level + 1);
    }
  }*/

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
