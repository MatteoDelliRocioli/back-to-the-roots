package delli;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class Main {

  public static void main(String[] args) {
  }

  List<List<Integer>> levels = new ArrayList<>();

  // Recursive BFS, starting from the root we keep adding elements to the list of
  // levels. If the number of levels is equal to the level number passed as
  // a parameter it means that we have a new level, so we must add it to the result
  /**
   * time complexity: O(n) because we iterate through all the nodes
   * space complexity: O(n) because the result will hold all the nodes from the tree
   * */
  public List<List<Integer>> levelOrder_recursive(TreeNode root) {

    if (root == null) {
      return levels;
    }

    helper(root, 0);

    return levels;
  }

  public void helper (TreeNode node, int level) {
    if (levels.size() == level) {
      List<Integer> newLevel = new ArrayList<>();

      levels.add(newLevel);
    }

    levels.get(level).add(node.val);

    if (node.left != null) {
      helper(node.left, level + 1);
    }
    if (node.right != null) {
      helper(node.right, level + 1);
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
