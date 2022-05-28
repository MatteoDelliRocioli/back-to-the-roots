package delli;

import java.util.ArrayList;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    Main main = new Main();
    main.helper();
  }

  public void helper() {
    middleNode(new ListNode());
  }

  public ListNode middleNode(ListNode head) {
    List<ListNode> myList = new ArrayList<>();
    ListNode current = head;

    while(current != null) {
      myList.add(current);
      current = current.next;
    }

    if (myList.size() == 0) {
      return myList.get((myList.size() / 2) + 1);
    }
    else {
      return myList.get(myList.size() / 2);
    }
  }

  public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
