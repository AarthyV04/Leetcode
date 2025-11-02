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
    public ListNode reverseList(ListNode head) {
        ListNode ptr=head, pptr=null, nptr=null;
        while(ptr!=null){
            nptr = ptr.next;
            ptr.next = pptr;
            pptr = ptr;
            ptr = nptr;
        }
        return pptr;
    }
}