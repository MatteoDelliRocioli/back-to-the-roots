package delli;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Main {

  /**
   * https://leetcode.com/problems/h-index/
   * */
  public static void main(String[] args) {
    int citations[] = {3, 0, 6, 1, 5};
//    int citations[] = {1, 3, 1};
//    int citations[] = {100};
//    int citations[] = {11, 15};


//    System.out.println(hIndex(citations));
    System.out.println(hIndex(citations));
  }

  /**
   * H is the maximum number of articles with at least h citations where this
   * number of articles is not larger then h
   * */
  public static int hIndex(int[] citations) {
    Arrays.sort(citations);
    int len = citations.length;
    for (int i = 0; i < len; i++) {
      if (citations[i] >= len - i)
        return len - i;
    }
    return 0;
  }
}
