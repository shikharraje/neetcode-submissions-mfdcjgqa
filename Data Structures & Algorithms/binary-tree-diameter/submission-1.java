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
    int maxDiameter;
    
    public int diameterOfBinaryTree(TreeNode root)
    {
        this.maxDiameter = Integer.MIN_VALUE;
        doDFS(root);
        return this.maxDiameter;
    }

    private int doDFS(TreeNode root)
    {
        if(root == null)
            return 0;
        else
        {
            int fromLeft = doDFS(root.left);
            int fromRight = doDFS(root.right);
            this.maxDiameter = Math.max(this.maxDiameter, fromLeft + fromRight);
            return 1 + Math.max(fromLeft, fromRight);
        }
    }
}
