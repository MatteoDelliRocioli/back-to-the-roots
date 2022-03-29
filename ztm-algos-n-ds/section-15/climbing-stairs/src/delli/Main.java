package delli;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Main {

  /**
   * https://leetcode.com/problems/climbing-stairs/
   * You are climbing a staircase. It takes n steps to reach the top.
   * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
   *
   * It's using fibonacci series
   * */
  public static void main(String[] args) {
    Map<Integer, Integer> map = new ConcurrentHashMap<>();
    int result = fib(7, map);
    System.out.println(result);
  }

  /**
   * A first brute force approach would be to use a fibonacci algorithm since
   * for each number of stairs we have that the total combinations of possibilities
   * is using fibonacci sequence
   * */
  public static int fib(int stairs, Map<Integer, Integer> map) {
    if (stairs < 4) {
      return stairs;
    }

    if (map.containsKey(stairs)) {
      return map.get(stairs);
    }

    int result = fib(stairs - 1, map) + fib(stairs - 2, map);

    map.put(stairs, result);

    return map.get(stairs);
  }
}
