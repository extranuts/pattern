package leetcode.PaliLinkedList;


/***
 *234. Palindrome Linked List
 *
 *
 * */

public class Solution {
    public boolean isPalindrome(ListNode head) {

        //set two pointers fast and slow starting at the head.
        ListNode slow = head;
        ListNode fast = head;

        //fast pointer goes to the end, and slow goes to the middle
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // the right half is reversed, and slow pointer becomes the 2nd head.
        slow = reversed(slow);
        fast = head;

        //run the two pointers head and slow together and compare.
        while (slow != null) {
            if(slow.val != fast.val){
               return false;
            }
            slow = slow.next;
            fast = fast.next;
        }
        return true;

    }

    private ListNode reversed(ListNode head) {

        ListNode prev = null;

        while(head!=null){
            ListNode next=head.next;
            head.next=prev;
            prev=head;
            head=next;
        }
        return  prev;
    }
}
