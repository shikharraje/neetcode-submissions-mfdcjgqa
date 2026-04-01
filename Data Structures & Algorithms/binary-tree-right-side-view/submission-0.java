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
    public List<Integer> rightSideView(TreeNode root)
    {
        List<Integer> res = new LinkedList<Integer>();

        LinkedList<TreeNode> currentLevel = new LinkedList<TreeNode>();
        LinkedList<TreeNode> nextLevel = new LinkedList<TreeNode>();

        if(root != null)
            currentLevel.addLast(root);
        
        while(!currentLevel.isEmpty())
        {
            TreeNode temp = currentLevel.pollFirst();

            if(temp.left != null)
                nextLevel.addLast(temp.left);
            if(temp.right != null)
                nextLevel.addLast(temp.right);
            
            if(currentLevel.isEmpty())
            {
                res.add(temp.val);

                currentLevel = nextLevel;
                nextLevel = new LinkedList<TreeNode>();
            }
        }

        return res;
    }
}
