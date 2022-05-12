package delli;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {

  public static void main(String[] args) {
    isPalindrome(",,,,,,,,,,,,acva");
  }

  public static boolean isPalindrome(String s) {
    String validChars = "abcdefghijklmnopqrstuvwxyz0123456789";

    char[] filtered = Arrays.asList(s.toLowerCase().split(""))
        .stream()
        .filter(validChars::contains)
        .collect(Collectors.joining())
        .toCharArray();

    int start = 0;
    int end = filtered.length - 1;

    while (start < end) {
      if (filtered[start] != filtered[end]) {
        return false;
      }
      start++;
      end--;
    }

    return true;
  }
}
