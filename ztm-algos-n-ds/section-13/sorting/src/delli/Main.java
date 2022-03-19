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
      if (arr[i] > arr[i + 1]) {
        System.out.println("i: " + arr[i]);
        System.out.println("j: " + arr[i + 1]);

        char temp = arr[i + 1];
        arr[i + 1] = arr[i];
        arr[i] = temp;

        if (i < arr.length -1) {
          i++;
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