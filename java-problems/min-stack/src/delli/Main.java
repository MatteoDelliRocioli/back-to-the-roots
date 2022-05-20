package delli;

public class Main {

  public static void main(String[] args) {
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
