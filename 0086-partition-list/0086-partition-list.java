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
    public ListNode partition(ListNode head, int x) {
        ListNode list1 = new ListNode(0);
        ListNode list2 = new ListNode(0);
        ListNode les = list1;
        ListNode grt = list2;
        ListNode temp=head;
        while(temp!=null){
            if(temp.val<x){
                les.next = temp;
                les = les.next;
            }
            else{
                grt.next = temp;
                grt = grt.next;

            }
            temp = temp.next;
        }
        grt.next = null;
        les.next = list2.next;
        return list1.next;

    }
}