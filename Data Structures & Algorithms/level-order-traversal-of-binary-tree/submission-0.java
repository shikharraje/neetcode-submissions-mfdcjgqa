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
    public List<List<Integer>> levelOrder(TreeNode root)
    {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> currentLevelNums = new LinkedList<Integer>();

        LinkedList<TreeNode> currentLevel = new LinkedList<TreeNode>();
        LinkedList<TreeNode> nextLevel = new LinkedList<TreeNode>();

        if(root != null)
            currentLevel.addLast(root);

        while(!currentLevel.isEmpty())
        {
            TreeNode temp = currentLevel.pollFirst();
            currentLevelNums.addLast(temp.val);

            if(temp.left != null)
                nextLevel.addLast(temp.left);
            if(temp.right != null)
                nextLevel.addLast(temp.right);
            
            if(currentLevel.isEmpty())
            {
                currentLevel = nextLevel;
                nextLevel = new LinkedList<TreeNode>();

                res.add(currentLevelNums);
                currentLevelNums = new LinkedList<Integer>();
            }
        }

        return res;
    }
}
