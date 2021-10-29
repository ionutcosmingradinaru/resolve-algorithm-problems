package com.ionutgradinaru.learning;

//Given an array of integers nums, calculate the pivot index of this array.
//The pivot index is the index where the sum of all the numbers strictly to the left of the index is equal to the sum of all the numbers strictly to the index's right.
//If the index is on the left edge of the array, then the left sum is 0 because there are no elements to the left. This also applies to the right edge of the array.
//Return the leftmost pivot index. If no such index exists, return -1.
//
//
//Example 1:
//Input: nums = [1,7,3,6,5,6]
//Output: 3
//Explanation:
//The pivot index is 3.
//Left sum = nums[0] + nums[1] + nums[2] = 1 + 7 + 3 = 11
//Right sum = nums[4] + nums[5] = 5 + 6 = 11
//
//Example 2:
//Input: nums = [1,2,3]
//Output: -1
//Explanation:
//There is no index that satisfies the conditions in the problem statement.
//
//Example 3:
//Input: nums = [2,1,-1]
//Output: 0
//Explanation:
//The pivot index is 0.
//Left sum = 0 (no elements to the left of index 0)
//Right sum = nums[1] + nums[2] = 1 + -1 = 0

import java.util.Arrays;
import java.util.List;

public class FindPivotIndex {

  public static void main(String[] args) {
    int[] nums = {2,1,-1};
    System.out.println(pivotIndex(nums));
  }

  public static int pivotIndex(int[] nums) {
    var size = nums.length;
    if (size == 0) {
      return -1;
    }

    var leftSum = 0;
    for (var i = 0; i < size; i++) {
      var rightSum = rightSum(i, nums);
      if (rightSum == leftSum) {
        return i;
      }
      leftSum += nums[i];
    }

    return -1;
  }

  public static int rightSum(final int leftIndex, int[] nums) {
    var sum = 0;
    for (var i = nums.length - 1; i > leftIndex; i--) {
      sum += nums[i];
    }

    return sum;
  }
}
