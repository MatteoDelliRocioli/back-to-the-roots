package delli;

import java.util.Arrays;
import java.util.Comparator;

public class Main {

  public static void main(String[] args) {
  }

  /**
   * naive solution
   * time complexity: due to sorting -> O(nlog(n))
   * space complexity: O(1), no additional space needed
   */
  public boolean canAttendMeetings(int[][] intervals) {
    //first sort array
    Arrays.sort(intervals, Comparator.comparingInt(x -> x[0]));
    // then for each occurrence starting from 1 check if the current
    // first value is in betwwen the previous two pair numbers

    for (int i = 1; i < intervals.length; i++) {
      if (intervals[i][0] < intervals[i - 1][1]) {
        return false;
      }
    }

    return true;
  }
}
