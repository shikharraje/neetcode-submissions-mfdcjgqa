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

    public int maxPathSum(TreeNode root)
    {
        this.res = Integer.MIN_VALUE;
        return Math.max(doDFS(root), Math.max(root.val, this.res));
    }

    private int doDFS(TreeNode root)
    {
        if(root.left == null && root.right == null)
            return root.val;
        else
        {
            if(root.left != null && root.right == null)
            {
                int fromLeft = doDFS(root.left);

                int option1 = fromLeft;
                int option2 = fromLeft + root.val;
                int option3 = root.val;

                int[] temp = new int[]{option1, option2, option3};
                Arrays.sort(temp);
                this.res = Math.max(this.res, temp[2]);
                return Math.max(option2, option3);
            }
            else if(root.left == null && root.right != null)
            {
                int fromRight = doDFS(root.right);

                int option1 = fromRight;
                int option2 = fromRight + root.val;
                int option3 = root.val;

                int[] temp = new int[]{option1, option2, option3};
                Arrays.sort(temp);
                this.res = Math.max(this.res, temp[2]);
                return Math.max(option2, option3);
            }
            else
            {
                int fromLeft = doDFS(root.left);
                int fromRight = doDFS(root.right);

                int option1 = fromLeft;
                int option2 = fromRight;
                int option3 = fromLeft + root.val;
                int option4 = fromRight + root.val;
                int option5 = root.val;
                int option6 = fromLeft + fromRight + root.val;

                int[] temp = new int[]{option1, option2, option3, option4, option5, option6};
                Arrays.sort(temp);
                this.res = Math.max(this.res, temp[5]);

                return Math.max(option3, Math.max(option4, option5));
            }
        }
    }
}
