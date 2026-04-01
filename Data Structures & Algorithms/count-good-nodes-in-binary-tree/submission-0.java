/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution
{
    int res;

    public int goodNodes(TreeNode root)
    {
        int[] tracker = new int[201];
        this.res = 0;
        doDFS(root, tracker);
        return this.res;
    }

    private void doDFS(TreeNode current, int[] tracker)
    {
        if(current == null)
            return;
        else
        {
            int index = 100 + current.val;
            if(containsGreater(index, tracker))
                this.res++;
            tracker[index]++;
            doDFS(current.left, tracker);
            doDFS(current.right, tracker);
            tracker[index]--;
        }
    }

    private boolean containsGreater(int index, int[] tracker)
    {
        for(int i = index + 1; i < tracker.length; i++)
        {
            if(tracker[i] > 0)
                return false;
        }
        return true;
    }
}
