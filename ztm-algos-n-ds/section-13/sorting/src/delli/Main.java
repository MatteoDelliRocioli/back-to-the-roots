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
    //int[] result = mergeSort(numbers);
    int[] result = quickSort(numbers);

    for (int x : result) {
      System.out.println(x);
    }
  }

  public static int[] quickSort(int[] numbers) {
    //pick the pivot as the last element in the array (there are other ways to
    // decide the pivot but that is out of this scope)
    //make sure that all the elements on the left of the pivot are lower and
    // right elements are greater -> that is, compared to the pivot, pick the
    // first greater element from the left and the first lower element from the
    // right, swap them and if the item from right is lower in index of item
    // from left then we have to stop and swap the item from left with the pivot

    //once the pivot is ok, we split the right part and the left part of the
    // array recursively to do the same again and again

    //We stop when we have sorted arrays of 2 or 3 elements
    if (numbers.length < 2) {
      return numbers;
    }

    int pivotPosition = numbers.length - 1;
    int pivot = numbers[pivotPosition];
    //search for the first element greater than the pivot starting from the left

    //search for the first lower element than the pivot starting from the right

    boolean isPivotSorted = false;
    int startingLeft = 0;
    int startingRight = numbers.length - 2;
    while(!isPivotSorted) {
      int[] left = null;
      int[] right = null;

      for (int i = startingLeft; i < numbers.length - 1; i++) {
        //search for higher
        if (numbers[i] > pivot) {
          left = new int[] {i, numbers[i]};
          //startingLeft = i;
          break;
        }
      }

      for (int j = startingRight; j >= 0; j--) {
        //search for lower
        if (numbers[j] < pivot) {
          right = new int[] {j, numbers[j]};
          //startingRight = j;
          break;
        }
      }

      if (left == null || right == null) {
        isPivotSorted = true;
        continue;
      }

//      if (left != null && right == null) {
//        //swap the pivot and return;
//        int temp = left[1];
//        numbers[left[0]] = pivot;
//        numbers[numbers.length - 1] = temp;
//
//        isPivotSorted = true;
//        pivotPosition = left[0];
//      }

//      if (left[0] == Integer.MIN_VALUE && right[0] == Integer.MIN_VALUE) {
//        isPivotSorted = true;
//        break;
//      }

      if (left[0] >= right[0]) {
        //we should swap left with pivot
        int temp = left[1];
        numbers[left[0]] = pivot;
        numbers[numbers.length - 1] = temp;

        isPivotSorted = true;
        pivotPosition = left[0];
      }
      else {
        //swap left and rigth
        int temp = left[1];
        numbers[left[0]] = numbers[right[0]];
        numbers[right[0]] = temp;

        //then we should keep searching
      }
    }

    //Recursion
    int[] leftSide = quickSort(Arrays.copyOfRange(numbers, 0, pivotPosition));
    int[] rightSide = quickSort(Arrays.copyOfRange(numbers, pivotPosition, numbers.length));

    int[] result = new int[leftSide.length + rightSide.length];

    System.arraycopy(leftSide, 0, result, 0, pivotPosition);
    System.arraycopy(rightSide, 0, result, pivotPosition, rightSide.length);

    return result;
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
  * with the first lower element
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