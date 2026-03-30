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
    public ListNode reverseList(ListNode head)
    {
        if(head == null)
            return null;
        return reverseListPair(head).start;
    }

    public Pair reverseListPair(ListNode current)
    {
        if(current.next == null)
            return new Pair(current);
        else
        {
            Pair reversedList = reverseListPair(current.next);
            current.next = null;
            reversedList.end.next = current;
            reversedList.end = reversedList.end.next;
            return reversedList;
        }
    }
}

class Pair
{
    public ListNode start;
    public ListNode end;

    public Pair(ListNode x)
    {
        this.start = x;
        this.end = x;
    }
}