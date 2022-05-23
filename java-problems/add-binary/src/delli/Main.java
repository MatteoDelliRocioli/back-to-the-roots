package delli;

public class Main {

  public static void main(String[] args) {
  }

  //WIP
  public String addBinary(String a, String b) {
    if (b.length() < a.length()) {
      return addBinary(b, a);
    }

    StringBuilder sb = new StringBuilder();
    Character remainder = '0';

    for (int i = a.length() - 1; i >= 0; i--) {
      int count = 0;

      System.out.println(a.charAt(i));
      count += a.charAt(i) == '0' ? 0 : 1;
      count += b.charAt(i) == '0' ? 0 : 1;
      count += remainder == '0' ? 0 : 1;

      remainder = update(sb, remainder, count);
    }

    for (int j = b.length() - a.length() - 1; j >= 0; j--) {
      int count = 0;
      count += b.charAt(j) == '0' ? 0 : 1;
      count += remainder == '0' ? 0 : 1;

      remainder = update(sb, remainder, count);
    }

    if (remainder == '1') {
      sb.append('1');
    }

    return sb.reverse().toString();
  }

  private char update(StringBuilder sb, Character remainder, int count) {
    switch (count) {
      case 0:
        sb.append('0');
        return '0';
      case 1:
        sb.append('1');
        return '0';
      case 2:
        sb.append('0');
        return '1';
      case 3:
        sb.append('1');
        return '1';
      default:
        return '-';
    }
  }
}
