package delli;

public class Main {

  public static void main(String[] args) {
    Main main = new Main();
    main.romanToInt("XX");
  }

  /**
   * time complexity: O(n) since we are going to iterate through all the chars of the
   *    input string
   * space complexity: O(1) since we are using only singly valued variables
   * */
  public int romanToInt(String s) {
    int current = 0;
    int sum = 0;

    while(current < s.length() - 1) {
      int next = parseChar(s.charAt(current + 1));
      int curr = parseChar(s.charAt(current));

      if (next == curr || next < curr) {
        sum += curr;
      }
      else {
        sum += next - curr;
        current++;
      }
      current++;
    }

    if (current != s.length()) {
      sum += parseChar(s.charAt(current));
    }

    return sum;
  }

  public int parseChar(char in) {
    switch (in) {
      case 'I':
        return 1;
      case 'V':
        return 5;
      case 'X':
        return 10;
      case 'L':
        return 50;
      case 'C':
        return 100;
      case 'D':
        return 500;
      case 'M':
        return 1000;
      default:
        return 0;
    }
  }
}
