package delli;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    Main main = new Main();
    main.helper();
  }

  public void helper() {
    preorderTraversal(new TreeNode());
  }

  public List<Integer> preorderTraversal(TreeNode root) {
    LinkedList<TreeNode> stack = new LinkedList<>();
    List<Integer> result = new ArrayList<>();

    if (root == null) {
      return result;
    }

    stack.add(root);

    while (!stack.isEmpty()) {
      TreeNode node = stack.pollLast();

      result.add(node.val);

      if (node.right != null) {
        stack.add(node.right);
      }

      if (node.left != null) {
        stack.add(node.left);
      }
    }

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
