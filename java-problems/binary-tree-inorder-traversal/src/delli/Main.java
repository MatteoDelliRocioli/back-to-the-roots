package delli;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    Main main = new Main();
    main.helper();
  }
  
  public void helper() {
    inorderTraversal(new TreeNode());
  }
  public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    return doTraversal(root, result);
  }
  
  public List<Integer> doTraversal(TreeNode root, List<Integer> result) {
    if (root == null) {
      return result;
    }
  
    if (root.left != null) {
      doTraversal(root.left, result);
    }
  
    result.add(root.val);
  
    if (root.right != null) {
      doTraversal(root.right, result);
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
