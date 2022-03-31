package delli;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

  /**
   * Given 2 sorted arrays merge them into one big sorted array
   *  Example data set:
   *  int [] {4, 6, 30};
   *  int [] {0, 3, 4, 31};
   * */
  public static void main(String[] args) {

    int[] arr1 = {4, 6, 30};
    int[] arr2 = {0, 3, 4, 31};
    bruteMerge(arr1, arr2);
  }

  /**
   * A first approach may be to use two pointers each for every array to merge
   * and increment its position as we add the arrays elements
   * if one of the arrays is terminated then we concatenate the remaining
   * elements of the others to the end of the resulting list
   * */
  public static List<Integer> bruteMerge(int[] arr1, int[] arr2) {
    List<Integer> result = new ArrayList<>();

    int y = 0;
    int z = 0;

    for (int i = 0; i < arr1.length + arr2.length; i++) {
      if (y == arr1.length) {
        List<Integer> list =
            Arrays.stream(arr2).boxed().collect(Collectors.toList());
        result.addAll(i, list.subList(z, list.size()));
        break;
      }
      if (z == arr2.length) {
        List<Integer> list =
            Arrays.stream(arr1).boxed().collect(Collectors.toList());
        result.addAll(i, list.subList(y, list.size()));
        break;
      }

      if (arr1[y] < arr2[z]) {
        result.add(arr1[y]);
        y++;
      }
      else {
        result.add(arr2[z]);
        z++;
      }
    }
    return result;
  }
}
