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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prevGroupEnd = dummy;
        while (true) {
            ListNode groupStart = prevGroupEnd.next;
            ListNode groupEnd = prevGroupEnd;
            for (int i = 0; i < k; i++) {
                groupEnd = groupEnd.next;
                if (groupEnd == null) return dummy.next; 
            }
            ListNode nextGroupStart = groupEnd.next;
            groupEnd.next = null; 
            ListNode reversedGroup = reverse(groupStart);
            prevGroupEnd.next = reversedGroup;
            groupStart.next = nextGroupStart; 
            prevGroupEnd = groupStart;
        }
    }
    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next; 
            curr.next = prev; 
            prev = curr; 
            curr = nextTemp;
        }
        return prev; 
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        int k = 2;
        ListNode newHead = solution.reverseKGroup(head, k);
        while (newHead != null) {
            System.out.print(newHead.val + " ");
            newHead = newHead.next;
        }
    }
}