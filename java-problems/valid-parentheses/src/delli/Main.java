package delli;

import java.util.Stack;

public class Main {

  /**
   * https://leetcode.com/problems/valid-parentheses/
   * */
  public static void main(String[] args) {
    isValid("()()(}}]][][]{{{]]");
  }

  /**
   * time complexity: O(n) where n is the string length
   * space complexity: O(n) where n could be the string length that is stored
   *  in the stack if the string only has opening brackets
   * */
  public static boolean isValid(String s) {
    Stack<Character> openingBrackets = new Stack<>();
    char[] chars = s.toCharArray();

    for (int i = 0; i < chars.length; i++) {
      switch(chars[i]) {
        case '(':
        case '[':
        case '{':
          openingBrackets.add(chars[i]);
          break;
        case ')':
        case ']':
        case '}':
          if (openingBrackets.isEmpty()) {
            return false;
          }

          char temp = openingBrackets.pop();
          if ((temp == '(' && chars[i] != ')') ||
              (temp == '[' && chars[i] != ']') ||
              (temp == '{' && chars[i] != '}')) {
            return false;
          }
          break;
      }
    }

    if (!openingBrackets.isEmpty()) {
      return false;
    }

    return true;
  }
}
