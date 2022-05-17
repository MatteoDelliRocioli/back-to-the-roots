package delli;

public class Main {

  public static void main(String[] args) {
  }

  public class VersionControl {
    public boolean isBadVersion(int x) {
      return false;
    }
  }

  /**
   * https://leetcode.com/problems/first-bad-version
   *
   * First implementation, works fine but gives TLE, too inefficient
   * */
  public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
      if (super.isBadVersion(1)) {
        return 1;
      }

      return helper(2, n/2, n);
    }

    public int helper(int leftPtr, int middlePtr, int rightPtr) {

      int diff = rightPtr - leftPtr;

      if (diff < 4) {
        for (int i = leftPtr; i < rightPtr; i++) {
          if (super.isBadVersion(i)) {
            return i;
          }
        }
      }


      if (super.isBadVersion(leftPtr) && !super.isBadVersion(leftPtr - 1)) {
        return leftPtr;
      }

      if (super.isBadVersion(middlePtr)) {
        if (!super.isBadVersion(middlePtr - 1)) {
          return middlePtr;
        }

        helper(leftPtr, middlePtr / 2, middlePtr);
      }

      if (super.isBadVersion(rightPtr)) {
        if (!super.isBadVersion(rightPtr - 1)) {
          return rightPtr;
        }

        helper(middlePtr, rightPtr / 2, rightPtr);
      }

      return leftPtr;
    }
  }

  /**
   * updated version of recursive approach
   * */

  /**
   * public class Solution extends VersionControl {
   *   public int firstBadVersion(int n) {
   *     if (super.isBadVersion(1)) {
   *       return 1;
   *     }
   *
   *     if (super.isBadVersion(n) && !super.isBadVersion(n - 1)) {
   *       return n;
   *     }
   *
   *     return helper(1, n);
   *   }
   *
   *   public int helper(int left, int right) {
   *     if (left - right < 4) {
   *       for (int i = left; i < right; i++) {
   *         if (!super.isBadVersion(i - 1) && super.isBadVersion(i))
   *           return i;
   *       }
   *     }
   *
   *     if (super.isBadVersion(left) | super.isBadVersion(right / 2)) {
   *       return helper(left, right/2);
   *     }
   *
   *     return helper(right /2, right);
   *   }
   * }
   * */

}
