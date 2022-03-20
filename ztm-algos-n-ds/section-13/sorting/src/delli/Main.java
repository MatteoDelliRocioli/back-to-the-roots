package delli;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    char[] letters = {'a', 'd', 'b', 'e', 'z', 'i'};
    int[] numbers = {8, 5, 2, 6, 9, 3, 1, 4, 0, 7};

    /*javaSort(letters);
    javaSort(numbers);*/

    //bubbleSort(letters);
    //selectionSort(numbers);
    //insertionSort(numbers);
    int[] result = mergeSort(numbers);

    for (int x : result) {
      System.out.println(x);
    }
  }
  public static int[] mergeSort(int[] numbers) {
    int inLength = numbers.length;

    if (inLength < 2) {
      return numbers;
    }

    int midRange = inLength / 2;

    int[] leftArr = Arrays.copyOfRange(numbers, 0, inLength - midRange);
    int[] rightArr = Arrays.copyOfRange(numbers, inLength - midRange, inLength);

    //recursive case
    if (inLength != 1 && inLength > 0) {
      leftArr = mergeSort(leftArr);
      rightArr = mergeSort(rightArr);
    }

    //merge
    int i = 0;
    int j = 0;
    int z = 0;
    boolean finishedLeftArr = false;
    boolean finishedRightArr = false;
    int[] result = new int[inLength];
    //base case
    while (z < inLength) {
      if (finishedLeftArr && !finishedRightArr) {
        result[z] = rightArr[j];
        j++;
        z++;
        continue;
      }
      if (finishedRightArr && !finishedLeftArr) {
        result[z] = leftArr[i];
        i++;
        z++;
        continue;
      }

      if (leftArr[i] < rightArr[j]) {
        result[z] = leftArr[i];
        if (i + 1 < leftArr.length) {
          i++;
        }
        else {
          finishedLeftArr = true;
        }
      }
      else {
        result[z] = rightArr[j];
        if (j + 1 < rightArr.length) {
          j++;
        }
        else {
          finishedRightArr = true;
        }
      }
      z++;
    }

    return result;
  }

  /**
  * The main iteration picks the next element in the collection and the inner
  * iteration loops back in the already seen elements to swap the current one
  * with the element wich is immediately Iterates through the collection
  *
  */
  public static void insertionSort(int[] numbers) {
    List<Integer> result = new ArrayList<>();
    for (int i = 0; i < numbers.length; i++) {
      int current = numbers[i];
      if (result.isEmpty()) {
        result.add(current);
        continue;
      }

      for (int j = 0; j < result.size(); j++) {
        if (current > result.get(j)) {
          if (j == result.size() -1) {
            result.add(current);
            break;
          }
          continue;
        }

        result.add(j, current);
        break;
      }
    }
    for (int x : result) {
     System.out.println(x);
    }
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