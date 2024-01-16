package Trees;

public class Main {

    public static void main(String[] args){
        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};

        TreeFromInorderPostorder t = new TreeFromInorderPostorder();

        System.out.println((t.buildTree(inorder, postorder)).val);
    }
    
}
