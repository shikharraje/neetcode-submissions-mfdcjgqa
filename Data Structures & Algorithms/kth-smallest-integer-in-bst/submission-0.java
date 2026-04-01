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
    int k;

    int res;

    public int kthSmallest(TreeNode root, int k)
    {
        this.k = k;
        this.res = -1;

        doDFS(root);

        return this.res;
    }

    private void doDFS(TreeNode root)
    {
        if(root == null)
            return;
        else
        {
            doDFS(root.left);
            this.k--;
            if(this.k == 0)
            {
                this.res = root.val;
                return;
            }
            doDFS(root.right);
        }        
    }
}
