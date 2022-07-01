/*
 #Problem 99
 Recover Binary Search Tree
*/



/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */

public class Solution {
    TreeNode first;
    TreeNode second;
    TreeNode pre;

    public void inorder(TreeNode root) {
        if (root == null)
            return;

        inorder(root.left);

        if (pre == null) {
            pre = root;
        } else {
            if (root.val < pre.val) {
                if (first == null) {
                    first = pre;
                }

                second = root;
            }
            pre = root;
        }

        inorder(root.right);
    }

    public void recoverTree(TreeNode root) {
        if (root == null)
            return;

        inorder(root);
        if (second != null && first != null) {
            int val = second.val;
            second.val = first.val;
            first.val = val;
        }

    }
}
