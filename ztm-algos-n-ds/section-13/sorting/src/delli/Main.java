package delli;
import java.util.Arrays;

public class Main {

  public static void main(String[] args) {
    char[] letters = {'a', 'd', 'b', 'e', 'z', 'i'};
    int[] numbers = {8, 5, 2, 6, 9, 3, 1, 4, 0, 7};

    /*javaSort(letters);
    javaSort(numbers);*/

    //bubbleSort(letters);
    selectionSort(numbers);
  }

  /**
  * Scans the collection of n elements n times to swap the first element with
  * the smallest element found in the collection. So the time complexity is
  * O(n^2) and the space complexity is O(1)
  */
  public static void selectionSort(int[] numbers) {
    for (int i = 0; i < numbers.length; i++) {
      int smallest = numbers[i];
      int smallestIndex = i;
      for (int j = i; j < numbers.length; j++) {
        if (numbers[j] < smallest) {
          smallest = numbers[j];
          smallestIndex = j;
        }
      }
      int temp = numbers[i];
      numbers[i] = smallest;
      numbers[smallestIndex] = temp;
    }

    for (int x : numbers) {
      System.out.println(x);
    }
  }

  /**
  * Swaps greater elements towards the right end of the collection
  * To do that it has to iterate through the array n times thus
  * time complexity is O(n^2) and space complexity is O(1)
  */
  public static void bubbleSort(char[] arr) {
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr.length; j++) {

        if (j == arr.length -1) {
          break;
        }

        if (arr[j] > arr[j + 1]) {
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