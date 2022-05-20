package delli;

public class Main {

  public static void main(String[] args) {
    Main main = new Main();
    main.helper();
  }

  public void helper() {
    MinStack stack = new MinStack();
    stack.getMin();
  }

  /**
   * time complexity: O(1) for each operation
   * space complexity: O(n) due to the fact that we have to store n nodes as many
   *  node are to be pushed in our stack
   * */
  class MinStack {
    class Node {
      int val;
      int min;
      Node next;

      Node (int val, int min, Node next) {
        this.val = val;
        this.min = min;
        this.next = next;
      }
    }

    Node head;

    public MinStack() {

    }

    public void push(int val) {
      int min = head != null ? head.min : val;

      Node node = new Node(val, Math.min(val, min), head);

      head = node;
    }

    public void pop() {
      head = head.next;
    }

    public int top() {
      return head.val;
    }

    public int getMin() {
      return head.min;
    }
  }

/**
 * brute force solution
 *
 * time complexity: O(n) because we iterate the stack each time we have to delete
 *    a node and thus define next min
 * space complexity: O(n) -> we store all the elements in a list
 *
 * Integer min = null;
 *   Integer last = null;
 *   LinkedList<Integer> innerStack = null;
 *
 *   public MinStack() {
 *     innerStack = new LinkedList<>();
 *   }
 *
 *   public void push(int val) {
 *     if (min == null) {
 *       min = val;
 *     }
 *     else {
 *       min = Math.min(min, val);
 *     }
 *
 *     innerStack.add(val);
 *   }
 *
 *   public void pop() {
 *     if (innerStack.peekLast() == null) {
 *       return;
 *     }
 *
 *     last = innerStack.removeLast();
 *
 *     if (!innerStack.isEmpty()) {
 *       min = innerStack.peek();
 *     }
 *
 *     for (int i = 0; i < innerStack.size(); i++) {
 *       min = Math.min(innerStack.get(i), min);
 *
 *       System.out.println(min);
 *     }
 *   }
 *
 *   public int top() {
 *     if (innerStack.peekLast() == null) {
 *       return last;
 *     }
 *
 *     int result = innerStack.peekLast();
 *
 *     last = result;
 *
 *     if (!innerStack.isEmpty()) {
 *       min = innerStack.peek();
 *     }
 *
 *     for (int i = 0; i < innerStack.size(); i++) {
 *       min = Math.min(innerStack.get(i), min);
 *       System.out.println(min);
 *     }
 *
 *     return result;
 *   }
 *
 *   public int getMin() {
 *     return min;
 *   }
 * */
}
