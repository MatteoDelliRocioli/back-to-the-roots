package delli.classes;

public class Node {
  Node[] children = new Node[] {null, null};
  int value = 0;

  Node(int value) {
    System.out.println(String.format("node created with value: %d", value));
    this.value = value;
  }
}
