package delli;

import java.util.HashSet;
import java.util.List;

public class Main {

  /**
   Given 2 arrays, create a function that let's a user know (true/false)
   whether these two arrays contain any common items
   For example:
   const array1 = ['a', 'b', 'c', 'x'];
   const array2 = ['z', 'y', 'i'];
   should return false;
   --------------------
   const array1 = ['a', 'b', 'c', 'x'];
   const array2 = ['z', 'y', 'x'];
   should return true;
   */

  /**
   * A first naive approach would be to iterate all the elements of the first
   * array to compare each of them with each element on the other array
   *
   * A more efficient way to do it would be to iterate all the elements of the
   * first array to store the elements in a HashSet and then use it to check if
   * any element on the second array has already been seen
   * */
  private static boolean hasBeenSeen(List<Character> arr1, List<Character> arr2) {
    HashSet<Character> seen = new HashSet<>(arr1);
    for(Character x : arr2) {
      if (seen.contains(x)) {
        return true;
      }
    }
    return false;
  }

  public static void main(String[] args) {
//    List<Character> array1 = List.of('a', 'b', 'c', 'x');
//    List<Character> array2 = List.of('z', 'y', 'i');
    List<Character> array1 = List.of('a', 'b', 'c', 'x');
    List<Character> array2 = List.of('z', 'y', 'x');

   boolean result = hasBeenSeen(array1, array2);

   System.out.println(result);
  }
}
