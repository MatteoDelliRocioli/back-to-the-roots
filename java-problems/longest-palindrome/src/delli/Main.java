package delli;

public class Main {

  /**
   * https://leetcode.com/problems/longest-palindrome/
   * */
  public static void main(String[] args) {
    Main main = new Main();
    main.longestPalindrome("ciao0");
  }

  /**
   * time complexity: O(n) where n is the maximum length between input word and 26
   * space complexity: O(n) due to the fact that we are storing values for two arrays of size 26
   * */
  public int longestPalindrome(String s) {
    int[] lower = new int[26];
    int[] upper = new int[26];

    for (int i = 0; i < s.length(); i++) {
      char current = s.charAt(i);
      int lowerPosition = current - 'a';
      int upperPosition = current - 'A';

      if (lowerPosition >= 0 && lowerPosition < 26) {
        lower[lowerPosition]++;
      }

      if (upperPosition >= 0 && upperPosition < 26) {
        upper[upperPosition]++;
      }
    }

    boolean hasOdd = false;
    int result = 0;

    for (int i = 0; i < lower.length; i++) {
      boolean isOdd = false;
      if (lower[i] % 2 != 0) {
        hasOdd = true;
        isOdd = true;
      }

      result += isOdd ? lower[i] - 1 : lower[i];

      isOdd = false;
      if (upper[i] % 2 != 0) {
        hasOdd = true;
        isOdd = true;
      }

      result += isOdd ? upper[i] - 1 : upper[i];
    }

    result += hasOdd ? 1 : 0;

    return result;
  }
}
