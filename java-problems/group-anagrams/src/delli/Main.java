package delli;

import javax.xml.stream.events.Characters;
import java.util.*;

public class Main {

  /**
   * https://leetcode.com/problems/group-anagrams/
   * */
  public static void main(String[] args) {
    Main main = new Main();

    var test = main.helper();

    System.out.println(test.size());
  }

  public List<List<String>> helper() {
    String[] input = new String[] {"eat","tea","tan","ate","nat","bat"};

    return groupAnagrams(input);
  }

  public List<List<String>> groupAnagrams(String[] strs) {
    List<List<String>> result = new ArrayList<>();
    Map<String, List<String>> map = new HashMap<>();

    for (int i = 0; i < strs.length; i++) {
      String key = getKey(strs[i]);
      List<String> list = new ArrayList<>();
      list.add(strs[i]);
      if (map.isEmpty()) {
        map.put(key, list);
      }
      else {
        if (map.containsKey(key)) {
          map.get(key).add(strs[i]);
        }
        else {
          map.put(key, list);
        }
      }
    }

    return new ArrayList<>(map.values());
  }

  public static String getKey(String input) {
    char[] chars = input.toCharArray();
    Arrays.sort(chars);
    return String.valueOf(chars);
  }

  public List<List<String>> groupAnagrams_firstAttempt(String[] strs) {
    Map<PriorityQueue<Character>, List<String>> map = new HashMap<>();

    for (int i = 0; i < strs.length; i++) {
      char[] letters = strs[i].toCharArray();
      PriorityQueue<Character> pq = new PriorityQueue<>((a, b) -> a - b);
      for (char x: letters) {
        pq.offer(x);
      }

      if (map.isEmpty()) {
        List<String> list = new ArrayList<>();
        list.add(strs[i]);
        map.put(pq, list);
        continue;
      }

//      while (!map.isEmpty()) {
        var queues = map.keySet();

        for (PriorityQueue<Character> queue : queues) {
          PriorityQueue<Character> mapKey = new PriorityQueue<>(queue);
          PriorityQueue<Character> tempPq = new PriorityQueue<>(pq);

          if (mapKey.size() == tempPq.size()) {
            while (!mapKey.isEmpty() && !tempPq.isEmpty() &&
                mapKey.poll() == tempPq.poll()) {

            }
            //if found
            if (mapKey.isEmpty() && tempPq.isEmpty()) {
              map.get(queue).add(strs[i]);
            }
            else {
              List<String> newStringList = new ArrayList<>();
              newStringList.add(strs[i]);
              map.put(pq, newStringList);
            }
          }
        }
//      }
    }


    return new ArrayList<>(map.values());
  }
}
