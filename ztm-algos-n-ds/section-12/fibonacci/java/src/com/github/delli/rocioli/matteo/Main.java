package com.github.delli.rocioli.matteo;

// Given a number N return the index value of the Fibonacci sequence, where the
// sequence is:
// 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144...

// The pattern of the sequence is that each value is the sum of the 2 previous
// values, that means that for N=5 -> 2+3

public class Main {

  public static void main(String[] args) {
    System.out.println(fibonacciIterative(10));
    fibonacciRecursive(6);
  }

  public static int fibonacciIterative(int index) {
    if (index < 2) {
      return index;
    }

    int parent = 1;
    int grandParent = 0;

    int i = 2;
    int current = 0;
    while (index > i) {
      current = grandParent + parent;
      grandParent = parent;
      parent = current;
      i++;
    }

    return current;
  }

  public static int fibonacciRecursive(int index) {
    return 0;
  }
}
