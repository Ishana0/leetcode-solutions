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
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0)
            return head;
        
        // Step 1: Find length
        ListNode temp = head;
        int length = 1;
        
        while (temp.next != null) {
            temp = temp.next;
            length++;
        }
        
        // Step 2: Make it circular
        temp.next = head;
        
        // Step 3: Adjust k
        k = k % length;
        
        int stepsToNewHead = length - k;
        
        ListNode newTail = temp;
        
        while (stepsToNewHead > 0) {
            newTail = newTail.next;
            stepsToNewHead--;
        }
        
        ListNode newHead = newTail.next;
        newTail.next = null;
        
        return newHead;
    }
}