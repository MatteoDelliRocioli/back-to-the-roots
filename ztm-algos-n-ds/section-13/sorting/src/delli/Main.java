package delli;
import java.util.Arrays;

public class Main {

  public static void main(String[] args) {
    char[] letters = {'a', 'd', 'b'};
    int[] numbers = {1, 5, 2};

    /*javaSort(letters);
    javaSort(numbers);*/

    bubbleSort(letters);
  }

  public static void bubbleSort(char[] arr) {
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr.length; j++) {

        if (j == arr.length -1) {
          break;
        }

        if (arr[j] > arr[j + 1]) {
          System.out.println("j: " + arr[j]);
          System.out.println("j + 1: " + arr[j + 1]);

          char temp = arr[j + 1];
          arr[j + 1] = arr[j];
          arr[j] = temp;
        }
      }
    }

    for (char x : arr) {
      System.out.println(x);
    }
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