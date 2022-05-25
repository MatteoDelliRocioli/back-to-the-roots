package delli;

public class Main {

  public static void main(String[] args) {
  }

  /**
   * time complexity: O(n) where n is the length of the longest of the two string inputs
   * space complexity: O(n) where n is the length of the longest of the two strings (possibly + 1 if carry == 1 at the end)
   * */
  public String addBinary(String a, String b) {
    StringBuilder sb = new StringBuilder(); // used to build result string

    int i = a.length() - 1;// we are going backwords to take into account least significant numbers first
    int j = b.length() - 1;

    int carry = 0; // at first the carry is always 0 (zero)

    while (i >= 0 || j >= 0) { // iterate till both the input strings are iterated
      int sum = carry; // the sum each time starts with the carry value
      if (i >= 0) sum += a.charAt(i) - '0'; // first convert the current chars to numbers
      if (j >= 0) sum += b.charAt(j) - '0'; // ASCII value of '1' is just 1 step forward of '0'

      sb.append(sum % 2);// decide what the result is for the current iteration
      carry = sum / 2;// decide the value of the carry for the next iteration

      i--;
      j--;
    }

    if (carry != 0) {
      sb.append(carry);
    }

    return sb.reverse().toString();
  }
}
