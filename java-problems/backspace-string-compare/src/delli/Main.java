package delli;

public class Main {

  public static void main(String[] args) {
  }

  /**
   * Use the stringBuilder as a stack for chars composing the final string
   * time complexity: O(n) where n is the sum of the two input lengths
   * space complexity: O(n) because in the worst case both strings have no '#'
   *    char and thus occupy fully the StringBuilder
   * */
  public boolean backspaceCompare(String s, String t) {
    String finalS = buildString(s);
    String finalT = buildString(t);

    return finalS.equals(finalT);
  }

  public String buildString(String s) {
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '#' && sb.length() > 0) {
        sb.deleteCharAt(sb.length() - 1);
      }
      else if (s.charAt(i) != '#'){
        sb.append(s.charAt(i));
      }
    }

    return sb.toString();
  }
}
