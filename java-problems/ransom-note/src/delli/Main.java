package delli;

import java.util.HashMap;
import java.util.Map;

public class Main {

  /**
   * https://leetcode.com/problems/ransom-note
   * */
  public static void main(String[] args) {
  }

  /**
   * First bruteforce implementation of the solution
   * time complexity: O(n) where n is the size of the magazine string
   * space complexity: O(n) where n is the size of the magazine string
   * */
  public boolean canConstruct(String ransomNote, String magazine) {
    Map<Character, Integer> availableChars = new HashMap<>();

    for (char c : magazine.toCharArray()) {
      if (!availableChars.containsKey(c)) {
        availableChars.put(c, 1);
      } else {
        availableChars.replace(c, availableChars.get(c) + 1);
      }
    }

    for (char c : ransomNote.toCharArray()) {
      if (!availableChars.containsKey(c)) { // no chars available
        return false;
      } else if (availableChars.get(c) < 1) { // no more chars occurrencies available for the specific char
        return false;
      } else {
        availableChars.replace(c, availableChars.get(c) - 1);
      }
    }

    return true;
  }

  /**
   * Using ASCII code int values for chars
   * */
//  public boolean canConstruct(String ransomNote, String magazine) {
//
//    int rasomNoteSize = ransomNote.length();
//
//    int[] arr = new int[26];
//    for(int i = 0; i<magazine.length(); i++){
//      arr[magazine.charAt(i)-'a']++;
//    }
//
//    for(int i = 0; i<rasomNoteSize; i++){
//      if(arr[ransomNote.charAt(i)-'a'] != 0){
//        arr[ransomNote.charAt(i)-'a']--;
//      }else{
//        return false;
//      }
//    }
//    return true;
//
//  }
}
