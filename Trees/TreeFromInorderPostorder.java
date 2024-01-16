package Trees;

/* Given two integer arrays inorder and postorder where inorder 
is the inorder traversal of a binary tree and postorder is the 
postorder traversal of the same tree, construct and return the binary tree.

 */

 import java.util.Arrays;


 
 
public class TreeFromInorderPostorder {
        
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        
        //base cases
        if(inorder.length == 1){
            return new TreeNode(inorder[0]);
        }
        
         if(postorder.length == 1){
            return new TreeNode(postorder[0]);
        }
    
        TreeNode root = new TreeNode(postorder[postorder.length - 1]);
        
        int pos1 = findIndexForGivenVal(inorder, postorder[postorder.length - 1]);
        System.out.println(pos1);
        
        //inorder-left-subArray
        int[] inLeftSubArray = Arrays.copyOfRange(inorder, 0, pos1-1);
        
        //postorder-left-subArray
        int[] postLeftSubArray = Arrays.copyOfRange(postorder, 0, pos1 - 1);
        
        
        //inorder-right-subArray
        int[] inRightSubArray = Arrays.copyOfRange(inorder, pos1 + 1, inorder.length);
        
        
        //postorder-right-subArray
        int[] postRightSubArray = Arrays.copyOfRange(postorder, inLeftSubArray.length, postorder.length - 1);
        
        //call to left subTree
        root.left = buildTree(inLeftSubArray, postLeftSubArray);
        
        //call to right subTree
        root.right = buildTree(inRightSubArray, postRightSubArray);
        
        return root;
        
    }//end-buildTree
    
    public int findIndexForGivenVal(int[] arr, int val){
        
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == val)
                return i;
            
            
        }//end-for
        return 0;
    }//end-funciton
    

}