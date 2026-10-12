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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }

        while (lists.length > 1) {
            ListNode[] mergedLists = new ListNode[(lists.length + 1) / 2];

            for (int i = 0; i < lists.length / 2; i++) {
                ListNode l1 = lists[2 * i];
                ListNode l2 = lists[2 * i + 1];

                mergedLists[i] = mergeTwoLists(l1, l2);
            }

            if (lists.length % 2 == 1) {
                mergedLists[mergedLists.length - 1] = lists[lists.length - 1];
            }

            lists = mergedLists;
        }

        return lists[0];
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                temp.next = l1;
                l1 = l1.next;
            } else {
                temp.next = l2;
                l2 = l2.next;
            }

            temp = temp.next;
        }

        if (l1 != null) {
            temp.next = l1;
        } else {
            temp.next = l2;
        }
        return dummy.next;
    }
}