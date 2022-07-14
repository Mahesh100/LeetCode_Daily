
/*
Defination of a Binary Tree Node
public class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) {this.val=val;}
    TreeNode(int val, TreeNode left, TreeNode right){
        this.val=val;
        this.left=left;
        this.right=right;
    }
}
*/

/*class Solution{
    public TreeNode buildTree(int[] preorder, int[] inorder){
        int preStart = 0;
        int preEnd=preorder.length-1;
        int inStart = 0;
        int inEnd = inorder.length-1;
        
        return construct(preorder, preStart, preEnd, inorder, inStart, inEnd);
    }
    
    /*public TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder){
        if(preStart>preEnd || inStart>inEnd)
            return null;
    }
    
    int val = preorder[preStart];
    TreeNode p = new TreeNode(val); 
     

    //find parent element index from inorder
    
        int k=0;
        for(int i=0; i<inorder.length; i++){
            if(val == inorder[i]){
                k=i;
                break;
            }
        }  
    
    public TreeNode construct(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd){
    if(preStart>preEnd||inStart>inEnd){
        return null;
    }
 
    int val = preorder[preStart];
    TreeNode p = new TreeNode(val);
 
    //find parent element index from inorder
    int k=0;
    for(int i=0; i<inorder.length; i++){
        if(val == inorder[i]){
            k=i;
            break;
        }
    }
        
        p.left=construct(preorder, preStart+1, preStart+(k=inStart), inorder, inStart, k-1);
        p.right=construct(preorder, preStart+(k-inStart)+1, preEnd, inorder, k+1,inEnd);

        return p;
}
} */  //Above code shows wrong Answer


class Solution{
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int preStart = 0;
        int preEnd = preorder.length-1;
        int inStart = 0;
        int inEnd = inorder.length-1;
     
        return construct(preorder, preStart, preEnd, inorder, inStart, inEnd);
    }
     
    public TreeNode construct(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd){
        if(preStart>preEnd||inStart>inEnd){
            return null;
        }
     
        int val = preorder[preStart];
        TreeNode p = new TreeNode(val);
     
        //find parent element index from inorder
        int k=0;
        for(int i=0; i<inorder.length; i++){
            if(val == inorder[i]){
                k=i;
                break;
            }
        }
     
        p.left = construct(preorder, preStart+1, preStart+(k-inStart), inorder, inStart, k-1);
        p.right= construct(preorder, preStart+(k-inStart)+1, preEnd, inorder, k+1 , inEnd);
     
        return p;
    }
    }