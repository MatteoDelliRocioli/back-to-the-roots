package delli;
import java.util.Arrays;

public class Main {

  public static void main(String[] args) {
    char[] letters = {'a', 'd', 'b'};
    int[] numbers = {1, 5, 2};

    javaSort(letters);
    javaSort(numbers);
  }

  public static void javaSort(char[] arr) {
    Arrays.sort(arr);

    for (char x : arr) {
      System.out.println(x);
    }
  }

  public static void javaSort(int[] arr) {
    Arrays.sort(arr);

    for (int x : arr) {
      System.out.println(x);
    }
  }
}