package delli;

import java.util.*;

public class Main {

  /**
   * https://leetcode.com/problems/merge-k-sorted-lists/
   * */
  public static void main(String[] args) {
    Main main = new Main();

    main.helper();
  }

  public ListNode helper() {

    ListNode l1 = new ListNode(1);
    ListNode l1_01 = new ListNode(4);
    ListNode l1_02 = new ListNode(5);
    l1.next = l1_01;
    l1_01.next = l1_02;

    ListNode l2 = new ListNode(2);
    ListNode l2_01 = new ListNode(6);
    l2.next = l2_01;

//    ListNode[] l3 = new ListNode[] {};
    ListNode l3 = new ListNode(1);
    ListNode l3_01 = new ListNode(3);
    ListNode l3_02 = new ListNode(4);
    l3.next = l3_01;
    l3_01.next = l3_02;

    ListNode[] lists = new ListNode[] {l1, l2, l3};

//    return mergeKLists(lists);
    return mergeKLists_w_priorityQueue(lists);
  }

  public ListNode mergeKLists_w_priorityQueue(ListNode[] lists) {
    ListNode result = new ListNode();
    ListNode current = result;
    PriorityQueue<ListNode> pq =
        new PriorityQueue<>((l1, l2)-> l1.val - l2.val);
    for(ListNode list: lists){
      if ( list != null) pq.offer(list);
    }

    while(!pq.isEmpty()){
      ListNode node = pq.poll();
      current.next = node;

      node = node.next;
      if( node != null) pq.offer(node);
      current = current.next;

    }

    return result.next;
  }

  public ListNode mergeKLists(ListNode[] lists) {
    var myLists = new ArrayList<ListNode>();
    myLists.addAll(Arrays.asList(lists));

    //maybe sorting lists first?

    ListNode root = null;
    myLists.removeIf(x -> x == null);

    while (!myLists.isEmpty()) {
      ListNode currentListHead = myLists.get(0);

      int min = currentListHead.val;
      Map<Integer, Integer> listPositionAndHeadValue = new HashMap<>();
      listPositionAndHeadValue.put(0, min);

      for (int i = 0; i < myLists.size(); i++) {
        ListNode current = myLists.get(i);

        if (current!= null && current.val < min) {
          min = current.val;
          listPositionAndHeadValue.clear();
          listPositionAndHeadValue.put(i, min);
        }
      }

      if (!listPositionAndHeadValue.isEmpty()) {
        // add node to the result linked list
        Integer listPosition =
            (Integer)listPositionAndHeadValue.keySet().toArray()[0];

        ListNode node = myLists.get(listPosition);

        if (root == null) {
          root = new ListNode(node.val);
        }
        else {
          ListNode current = root;
          while (current.next != null){
            current = current.next;
          }
          current.next = new ListNode(node.val);
        }

        // delete head from lists
        //is multiple nodes? (has next)
        if (node.next != null) {
          myLists.set(listPosition, node.next); // check if it updates the lists list head
        }
        //is only one node? (does not have next)
        else {
          myLists.remove(myLists.get(listPosition));
        }
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
