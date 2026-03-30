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
        if(head == null || head.next == null)
            return head;
        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode listIterator = head;
        while(listIterator != null)
        {
            ListNode temp = listIterator.next;
            listIterator.next = null;
            stack.push(listIterator);
            listIterator = temp;
        }
        ListNode result = stack.pop();
        listIterator = result;
        while(!stack.isEmpty())
        {
            listIterator.next = stack.pop();
            listIterator = listIterator.next;
        }
        return result;
    }
}
