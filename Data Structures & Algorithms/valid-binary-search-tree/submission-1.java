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
                  public boolean isValidBST(TreeNode root)
                      {
                              return isValidBST(root, -1001, 1001);
                                  }

                                      private boolean isValidBST(TreeNode root, int minSoFar, int maxSoFar)
                                          {
                                                  if(root == null)
                                                              return true;
                                                                      return root.val < maxSoFar && root.val > minSoFar && isValidBST(root.left, minSoFar, root.val) && isValidBST(root.right, root.val, maxSoFar);
                                                                          }
                                                                          }
                                                                          