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
    public List<Integer> rightSideView(TreeNode root) {
    ArrayList<Integer> result = new ArrayList<Integer>();
 
    if(root == null) return result;
 
    LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
    queue.add(root);
 
    while(queue.size() > 0){
        //get size here
        int size = queue.size();
 
        for(int i=0; i<size; i++){
            TreeNode top = queue.remove();
 
            //the first element in the queue (right-most of the tree)
            if(i==0){
                result.add(top.val);
            }
            //add right first
            if(top.right != null){
                queue.add(top.right);
            }
            //add left
            if(top.left != null){
                queue.add(top.left);
            }
        }
    }
 
    return result;
}
}