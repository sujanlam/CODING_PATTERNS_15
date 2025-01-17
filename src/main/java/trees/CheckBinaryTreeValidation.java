package trees;

import java.util.Stack;

public class CheckBinaryTreeValidation {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(3);
        root.left.left.left = null;
        root.left.left.right = null;
        System.out.println(height(root));
        System.out.println(isValidBST(root));
    }
    public static boolean isValidBST(TreeNode root){
        return height(root) != -1;
    }
    public static int height(TreeNode node){
        if(node == null){
            return 0;
        }

        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        if(leftHeight == -1){
            return -1;
        }
        if(rightHeight == -1){
            return -1;
        }

        if(Math.abs(leftHeight - rightHeight) > 1){
            return -1;
        }

        return 1+(Math.max(leftHeight, rightHeight));
    }
}
