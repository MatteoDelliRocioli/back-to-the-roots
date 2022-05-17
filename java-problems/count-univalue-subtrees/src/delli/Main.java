package delli;

public class Main {

  public static void main(String[] args) {
    Main main = new Main();
    main.helper();
  }

  public void helper() {
    countUnivalSubtrees(null);
  }

  int counter = 0;
  public int countUnivalSubtrees(TreeNode root) {
    if (root == null) {
      return 0;
    }

    countUniValues(root);

    return counter;
  }

  public boolean countUniValues(TreeNode node) {
    if (node.left == null && node.right == null) {
      counter++;
      return true;
    }

    boolean isUniVal = true;

    if (node.left != null) {
      isUniVal = countUniValues(node.left) && isUniVal && node.left.val == node.val;
    }

    if (node.right != null) {
      isUniVal = countUniValues(node.right) && isUniVal && node.right.val == node.val;
    }

    if (!isUniVal) {
      return false;
    }

    counter++;
    return true;
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
