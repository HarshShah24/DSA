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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {


        int carry = 0;
        ListNode dummy = new ListNode();
        ListNode head = dummy;

        while(l1 != null && l2 != null){
            int d1 = l1.val;
            int d2 = l2.val;
            int sum = d1 + d2 + carry;
            if(sum >= 10){
                carry = sum/10;
                sum = sum%10;
            }else{
                carry = 0;
            }
            final ListNode node = new ListNode(sum);
            head.next = node;
            head = head.next;

            l1 = l1.next;
            l2 = l2.next;
        }

        while(l1 != null){
            int d1 = l1.val;
            int sum = d1 + carry;
            if(sum >= 10){
                carry = sum / 10;
                sum = sum%10;
            }else{
                carry = 0;
            }
            final ListNode node = new ListNode(sum);
            head.next = node;
            head = head.next;
            l1 = l1.next;
        }

        while(l2 != null){
            int d2 = l2.val;
            int sum = d2 + carry;
            if(sum >= 10){
                carry = sum / 10;
                sum = sum%10;
            }else{
                carry = 0;
            }
            final ListNode node = new ListNode(sum);
            head.next = node;
            head = head.next;
            l2 = l2.next;
        }

        if(carry != 0){
            head.next = new ListNode(carry);
        }


        return dummy.next;
    }
}