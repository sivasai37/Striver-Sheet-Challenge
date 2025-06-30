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
        ListNode dummy = new ListNode(0);
        ListNode t1 = l1 ,t2 = l2 ,current = dummy;
        int c =0,sum=0;
        while(t1!=null||t2!=null){
            sum = c;
            if(t1!=null){
                sum = sum + t1.val;
                t1 = t1.next;
            }
            if(t2!=null){
                sum = sum + t2.val;
                 t2 = t2.next;
            }
            c = sum/10;
            current.next = new ListNode(sum%10);
            current = current.next;
            
          
        }
        if(c>0){
            current.next = new ListNode(c);
        }
        return dummy.next;
    }
}