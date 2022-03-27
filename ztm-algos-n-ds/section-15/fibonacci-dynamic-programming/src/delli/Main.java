package delli;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Main {

  public static void main(String[] args) {
  // write your code here
    System.out.println(memo(7));
  }

  public static int memo(int index) {
    Map<Integer, Integer> map = new ConcurrentHashMap<>();
    return fib(index, map);
  }

  public static int fib(int index, Map<Integer, Integer> map) {
    if (index < 2) {
      if (map.containsKey(index)){
        return map.get(index);
      }
      return index;
    }

    if (map.containsKey(index)) {
      return map.get(index);
    }

    int result = fib(index-1, map) + fib(index-2, map);

    map.put(index, result);

    return map.get(index);
  }
}
