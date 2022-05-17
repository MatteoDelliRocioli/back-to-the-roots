package delli;

import java.util.LinkedList;

public class Main {

  /**
   * https://leetcode.com/problems/implement-queue-using-stacks/
   *
   * time complexity: O(n) where n is the number of items put into the queue
   * space complexity: O(n) because we are using two stacks but both will have at max
   *  the number of queue elements
   * */
  public static void main(String[] args) {
  }

  public class MyQueue {
    private LinkedList<Integer> stack_1;
    private LinkedList<Integer> stack_2;

    public MyQueue() {
      this.stack_1 = new LinkedList<>();
      this.stack_2 = new LinkedList<>();
    }

    public void push(int x) {
      stack_1.add(x);
    }

    public int pop() {
      while (!stack_1.isEmpty()) {
        stack_2.add(stack_1.remove());
      }

      int result = stack_2.remove();

      while (!stack_2.isEmpty()) {
        stack_1.add(stack_2.remove());
      }

      return result;
    }

    public int peek() {
      while (!stack_1.isEmpty()) {
        stack_2.add(stack_1.remove());
      }

      int result = stack_2.peek();

      while (!stack_2.isEmpty()) {
        stack_1.add(stack_2.remove());
      }

      return result;
    }

    public boolean empty() {
      return stack_1.isEmpty();
    }
  }
}
