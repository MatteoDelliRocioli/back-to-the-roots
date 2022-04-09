package delli;

public class Main {

  public static void main(String[] args) {
    int left = 1;
    int right = 2147483647;
    System.out.println(rangeBitwiseAnd(left, right));
  }

  //brian kernighan's algorithm
  public static int rangeBitwiseAnd(int left, int right) {
    while (right > left) {
      right = right & right - 1;
    }
    return left & right;
  }

  public static int rangeBitwiseAnd_bruteforceApproach(int left, int right) {
    int result = left;

    for (int i = left; i <= right; i++) {
      if (i == Integer.MAX_VALUE) {
        return 0;
      }
      result = result & i;
    }

    return result;
  }
}
