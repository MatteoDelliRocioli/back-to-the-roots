package delli.bst;

public class Tree {
  public TreeNode root = new TreeNode();

  public Tree(int value) {
    root.val = value;
  }

  public void addNode(int value) {
    TreeNode node = new TreeNode(value);
    addNode(node);
  }

  public void addNode(TreeNode node) {
    TreeNode current = root;
    if (node.val == root.val) {
      return;
    }

    while(node.val != current.val) {

      if (current.left != null && node.val < current.val) {
        current = current.left;
        continue;
      }

      if (current.right != null && node.val > current.val) {
        current = current.right;
        continue;
      }

      if (current.left == null && node.val < current.val) {
        current.left = node;
        continue;
      }

      if (current.right == null && node.val > current.val) {
        current.right = node;
        continue;
      }

      break;
    }
  }
}
