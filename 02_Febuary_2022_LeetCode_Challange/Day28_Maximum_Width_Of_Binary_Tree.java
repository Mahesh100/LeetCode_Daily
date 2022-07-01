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
    int max_width;
    HashMap<Integer,Integer> leftmost_positions;
    public int widthOfBinaryTree(TreeNode root) {
        max_width=0;
        leftmost_positions = new HashMap();
        get_width(root, 0, 0);
        return max_width;
        
    }
    
    public void get_width(TreeNode root, int depth, int position){
        if(root ==null) 
            return;
        leftmost_positions.computeIfAbsent(depth, x->position);
        max_width=Math.max(max_width, position-leftmost_positions.get(depth)+1);
        get_width(root.left, depth+1, position*2);
        get_width(root.right, depth+1, position*2+1);
    }
}