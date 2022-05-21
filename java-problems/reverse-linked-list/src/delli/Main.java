package delli;

public class Main {

  /**
   * https://leetcode.com/problems/reverse-linked-list
   */
  public static void main(String[] args) {
    Main main = new Main();
    main.helper();
  }

  public void helper() {
    reverseList(new ListNode());
  }

  public ListNode reverseListOptimized(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode prev, curr;

    prev = head;

    curr = prev.next;
    prev.next = null;

    while (curr != null) {
      ListNode temp = curr.next;
      curr.next = prev;
      curr = temp;
    }

    return prev;
  }

  /**
   * My approach tries to reverse the linked list in-place using pointers to nodes
   *
   * time complexity: O(n) where n is the number of the list's nodes
   * space complexity: O(1) because we are only using 3 pointers to nodes and not saving anything else
   * */
  public ListNode reverseList(ListNode head) {
    ListNode prev, curr, post;

      if (head == null) {
      return null;
    }

    prev = head;

      if (prev.next == null) {
      return prev;
    }

    curr = prev.next;

    prev.next = null;

      do {
      post = curr.next;
      curr.next = prev;

      if (post != null) {
        prev = curr;
        curr = post;
      }
    } while(post != null);

      return curr;
  }
  public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
