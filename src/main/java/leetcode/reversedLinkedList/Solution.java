package leetcode.reversedLinkedList;


/***
 * 206.
 * Given the head of a singly linked list,
 * reverse the list, and return the reversed list.
 /**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode preview = null;
        while (head!=null){
            ListNode next  = head.next;
            head.next = preview;
            preview = head;
            head = next;
        }
        return preview;
    }
}