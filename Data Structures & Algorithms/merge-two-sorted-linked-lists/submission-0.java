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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null && list2 == null)
            return null;
        else if(list1 == null && list2 != null)
            return list2;
        else if(list1 != null && list2 == null)
            return list1;
        else
        {
            if(list1.val < list2.val)
            {
                ListNode current = list1;
                ListNode temp = list1.next;
                list1.next = null;
                current.next = mergeTwoLists(temp, list2);
                return current;
            }
            else if(list1.val > list2.val)
            {
                ListNode current = list2;
                ListNode temp = list2.next;
                list2.next = null;
                current.next = mergeTwoLists(list1, temp);
                return current;
            }
            else
            {
                ListNode current1 = list1;
                ListNode temp1 = list1.next;
                list1.next = null;

                ListNode current2 = list2;
                ListNode temp2 = list2.next;
                list2.next = null;

                current1.next = current2;
                current2.next = mergeTwoLists(temp1, temp2);
                return current1;
            }
        }
    }
}