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
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode oddHead = head;
        ListNode evenHead = head.next;
        ListNode even = evenHead;
        while (even != null && even.next != null) {
            oddHead.next = even.next;
            oddHead = oddHead.next;
            even.next = oddHead.next;
            even = even.next;
        }
        oddHead.next = evenHead;
        return head;
    }
}