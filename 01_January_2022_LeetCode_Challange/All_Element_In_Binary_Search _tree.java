class Solution {

List<Integer> result = new ArrayList<>();

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {

        if(root1 == null && root2 == null)
            return result;

        helper(root1);
        helper(root2);
        Collections.sort(result);

        return result;
    }


    private void helper(TreeNode root){
        if(root == null)
            return;
        else {
            result.add(root.val);
            helper(root.left);
            helper(root.right);
        }
    }

}
