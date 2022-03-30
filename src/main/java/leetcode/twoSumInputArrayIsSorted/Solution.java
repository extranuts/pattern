package leetcode.twoSumInputArrayIsSorted;


/***
 * 167 Solution
 * Given a 1-indexed array of integers numbers that is already sorted
 * in non-decreasing order, find two numbers such that they add up to
 * a specific target number. Let these two numbers be numbers[index1]
 * and numbers[index2] where 1 <= index1 < index2 <= numbers.length.
 *
 * Return the indices of the two numbers, index1 and index2, added
 * by one as an integer array [index1, index2] of length 2.
 *
 * The tests are generated such that there is exactly one solution.
 * You may not use the same element twice.
 *
 * Your solution must use only constant extra space.
 *
 * */
public class Solution {
    public int[] twoSum(int[] numbers, int target) {

        int x = 0;
        int y = numbers.length - 1;

        while (x <= y) {
            int sum = numbers[x] + numbers[y];

            if (sum > target) {
                y -= 1;
            } else if (sum < target) {
                x += 1;
            } else {
                return new int[]{x + 1, y + 1};
            }
        }
        return new int[]{x + 1, y + 1};
    }
}
