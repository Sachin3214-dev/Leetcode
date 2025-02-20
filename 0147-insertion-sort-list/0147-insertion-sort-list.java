class Solution {
   
    public ListNode insertionSortList(ListNode head) {
        //making a dummy node to avoid edge cases
        ListNode dummy  = new ListNode(-1);
        //  prev moves from starting to value who is just lesser than the next.val
        ListNode prev = dummy;
        // we use it to compare the adjacent values
        ListNode curr =  head;
        ListNode next = head.next;
        dummy.next = head;
        while(next!=null)
        {
            // first check , if this is true then continue 
            if(curr.val <=next.val)
            {
                curr =  curr.next;
                next = curr.next;
                continue;
            }
            
            // keep moving prev as discussed 
            while(prev.next !=null && prev.next.val<next.val)
            {
                prev =  prev.next;
            }
            // inserting the lesser valued after prev, all the 3 pointers come in use 
            curr.next= next.next;
            next.next = prev.next;
            prev.next = next;
            // initialising the pointer back to their required positions
            prev = dummy;
            next = curr.next;
        }
        
        return dummy.next;
    }
}
// -1 -1 5 3 4 0 
//  p    c n
//