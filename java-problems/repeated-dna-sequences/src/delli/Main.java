package delli;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

  /**
   * https://leetcode.com/problems/repeated-dna-sequences/
   * */
  public static void main(String[] args) {
//    String input = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
    String input = "AAAAAAAAAAA";
//    findRepeatedDnaSequences_bruteForce(input);
    findRepeatedDnaSequences(input);
  }

  public static List<String> findRepeatedDnaSequences(String s) {
    Set<String> result = new HashSet<>();

    if (s.length() < 10) {
      return new ArrayList<>(result);
    }

    String sCopy = s.substring(0);

    HashSet<String> subs = new HashSet<>();
    while (sCopy.length() >= 10) {
      String sub = sCopy.substring(0, 10);
      var isUnique = subs.add(sub);
      if (!isUnique) {
        result.add(sub);
      }
      sCopy = sCopy.substring(1);
    }
    return new ArrayList<>(result);
  }

  // bruteforce way
  // compare each substring of 10 chars with the original string minus the first char
  public static List<String> findRepeatedDnaSequences_bruteForce(String s) {
    Set<String> result = new HashSet<>();

    if (s.length() <= 10) {
      return new ArrayList<>(result);
    }

    while (s.length() > 10) {
      String sub = s.substring(0, 10);
      s = s.substring(1);
      if (s.contains(sub)) {
        result.add(sub);
      }
    }

    return new ArrayList<>(result);
  }
}
