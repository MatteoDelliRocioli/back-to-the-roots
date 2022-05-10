package delli;

import java.util.List;

public class Main {

  public static void main(String[] args) {
    Main main = new Main();
    main.helper();
  }

  public void helper() {
    this.mergeTwoLists(new ListNode(), new ListNode());
  }

  /**
   * We are copying the elements into a new linkedList so the resulting space
   * complexity: O(n) and the time complexity is O(n) as well
   * */
  public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    if (list1 == null && list2 == null) {
      return null;
    }

    ListNode pointer = new ListNode();
    ListNode result = pointer;

    while (list1 != null && list2 !=null) {
      int l1Val = list1.val;
      int l2Val = list2.val;

      pointer.val = Math.min(l1Val, l2Val);

      if (pointer.val == l1Val) {
        list1 = list1.next;
      }
      else {
        list2 = list2.next;
      }

      ListNode next = new ListNode();
      pointer.next = next;
      pointer = next;
    }

    while (list1 == null && list2 != null) {
      pointer.val = list2.val;
      list2 = list2.next;

      if (list2 == null) {
        continue;
      }

      ListNode next = new ListNode();
      pointer.next = next;
      pointer = next;
    }

    while (list2 == null && list1 != null) {
      pointer.val = list1.val;
      list1 = list1.next;

      if (list1 == null) {
        continue;
      }

      ListNode next = new ListNode();
      pointer.next = next;
      pointer = next;
    }

    pointer = null;

    return result;
  }

  public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
