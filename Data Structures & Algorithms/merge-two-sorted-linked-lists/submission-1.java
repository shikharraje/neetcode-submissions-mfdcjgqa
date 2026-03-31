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

class Solution
{
    public ListNode mergeTwoLists(ListNode list1, ListNode list2)
    {
        if(list1 == null && list2 != null)
            return list2;
        if(list1 != null && list2 == null)
            return list1;
        if(list1 == null && list2 == null)
            return null;

        
        if(list1.val < list2.val)
        {
            ListNode temp = list1.next;
            list1.next = mergeTwoLists(temp, list2);
            return list1;
        }
        else if(list1.val > list2.val)
        {
            ListNode temp = list2.next;
            list2.next = mergeTwoLists(list1, temp);
            return list2;
        }
        else
        {
            ListNode temp1 = list1.next;
            ListNode temp2 = list2.next;
            list1.next = list2;
            list2.next = mergeTwoLists(temp1, temp2);
            return list1;
        }
    }
}