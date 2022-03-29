package leetcode.palindromeNumber;

/***
 *
 * Given an integer x, return true if x is palindrome integer.
 *
 * An integer is a palindrome when it reads the same backward as forward.
 *
 * For example, 121 is a palindrome while 123 is not.
 *
 * */
class Solution {
    public boolean isPalindrome(int x) {
        if (x == 0) {
            return true;
        }
        if (x < 0 || x % 10 == 0) {
            return false;
        }

        int reversedInt = 0;
        while (x > reversedInt) {
            int pop = x % 10;
            x /= 10;

            reversedInt = (reversedInt * 10) + pop;
        }
        if (x == reversedInt || x == reversedInt / 10) {
            return true;
        } else {
            return false;
        }
    }
}