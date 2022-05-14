package delli;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
      Main main = new Main();
      main.solve();
    }

    public List<Integer> solve() {
      return postorderTraversal_r(new TreeNode(2));
    }

    // recursive
    public List<Integer> postorderTraversal_r(TreeNode root) {
      List<Integer> result = new ArrayList<>();

      return helper(root, result);
    }

    public List<Integer> helper(TreeNode root, List<Integer> result) {
      if (root == null) {
        return result;
      }

      helper(root.left, result);
      helper(root.right, result);
      result.add(root.val);

      return result;
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
