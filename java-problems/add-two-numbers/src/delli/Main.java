package delli;

import org.w3c.dom.Node;

public class Main {

  /**
   * https://leetcode.com/problems/add-two-numbers/
   *
   *  Definition for singly-linked list.
   *  public class ListNode {
   *    int val;
   *    ListNode next;
   *    ListNode() {}
   *    ListNode(int val) { this.val = val; }
   *    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
   *  }
   *

      class Solution {

        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

      }
   *
  }
   * */
  public static void main(String[] args) {
    Main main = new Main();
    main.helper();
  }

  public void helper() {
    ListNode root1 = new ListNode(9);
    ListNode child1_1 = new ListNode(9);
    ListNode child1_2 = new ListNode(9);

    root1.next = child1_1;
    child1_1.next = child1_2;

    ListNode root2 = new ListNode(9);
    ListNode child2_1 = new ListNode(9);
//    ListNode child2_2 = new ListNode(6);

    root2.next = child2_1;
//    child2_1.next = child2_2;

    var test = addTwoNumbers(root1, root2);

    System.out.println(test.val);
  }

  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

    ListNode root = null;
    ListNode current = null;
    int remainder = 0;

    while(true) {
      int l1Val = l1 == null ? 0 : l1.val;
      int l2Val = l2 == null ? 0 : l2.val;

      int nextNodeValue = l1Val + l2Val + remainder;

      if (nextNodeValue > 9) {
        remainder = nextNodeValue / 10;
        nextNodeValue = nextNodeValue % 10;
      }
      else {
        remainder = 0;
      }

      ListNode newNode = new ListNode(nextNodeValue);

      if (l1 == null && l2 == null) {
        if (newNode.val != 0) {
          current.next = newNode;
        }
        break;
      }

      if (root == null) {
        root = newNode;
        current = newNode;
      }
      else {
        current.next = newNode;
        current = current.next;
      }

      if (l1 != null) {
        l1 = l1.next;
      }
      if (l2 != null) {
        l2 = l2.next;
      }
    }

    return root;
  }

  public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
