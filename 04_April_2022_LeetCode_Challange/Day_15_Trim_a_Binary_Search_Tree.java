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

class Solution {
    public TreeNode trimBST(TreeNode R, int L, int H) {
        if (R == null) return R;
        if (R.val < L) return trimBST(R.right,L,H);
        else if (R.val > H) return trimBST(R.left,L,H);
        R.left = trimBST(R.left,L,H) ;
        R.right = trimBST(R.right,L,H);
        return R;
    }
}
