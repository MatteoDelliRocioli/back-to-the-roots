package delli;

import java.util.Stack;

public class Main {

  /**
   * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
   * */
  public static void main(String[] args) {

    Main main = new Main();

    main.helper();
  }

  public ListNode helper() {
    ListNode head = new ListNode(1);
    ListNode child1 = new ListNode(2);
    ListNode child2 = new ListNode(3);
    ListNode child3 = new ListNode(4);
    ListNode child4 = new ListNode(5);

    head.next = child1;
    child1.next = child2;
    child2.next = child3;
    child3.next = child4;
    int n = 2;

    return removeNthFromEnd(head, n);
  }

  public ListNode removeNthFromEnd(ListNode head, int n) {

    Stack<ListNode> stack = new Stack<>();
    ListNode current = head;

    // Populate the stack with all the singly linked list nodes
    while (current != null) {
      stack.push(current);
      current = current.next;
    }

    //ith element of the stack
    int i = 1;
    while (!stack.isEmpty() || i <= n) {
      if (i == n) {
        //3 cases
        //tail
        if (i == 1) {
          if (stack.size() != 1) {
            stack.pop();
            var parent = stack.pop();
            parent.next = null;
            return head;
          }
          else {
            return null;
          }
        }

        //midst
        if (stack.size() != 1) {
          var child = stack.pop().next;
          var parent = stack.pop();
          parent.next = child;
          return head;
        }
        else {
          //head
          if (stack.peek().next != null) {
            return head.next;
          }
        }
      }
      i++;
      stack.pop();
    }

    return head;
  }

  public class ListNode {
   int val;
   ListNode next;
   ListNode() {}
   ListNode(int val) { this.val = val; }
   ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

}
