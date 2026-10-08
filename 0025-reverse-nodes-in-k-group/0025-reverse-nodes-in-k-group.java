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
    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverse(head.next);
        ListNode front = head.next;
        front.next = head;
        head.next = null;
        return newHead;
    }

    public ListNode getKthNode(ListNode head, int k) {
        ListNode temp = head;
        k -= 1;
        while (k-- > 0 && temp != null) {
            temp = temp.next;
        }
        return temp;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        ListNode prevNode = null;
        while (temp != null) {
            ListNode kthNode = getKthNode(temp, k);
            if (kthNode == null) {
                if (prevNode != null) {
                    prevNode.next = temp;
                    break;
                }
            } else {
                ListNode nextNode = kthNode.next;
                kthNode.next = null;
                reverse(temp);
                if (temp == head) {
                    head = kthNode;
                } else {
                    prevNode.next = kthNode;
                }
                prevNode = temp;
                temp = nextNode;
            }
        }
        return head;
    }
}