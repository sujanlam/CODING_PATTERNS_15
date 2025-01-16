package trees;

import java.util.Stack;

public class InvertBinaryTree {
    public TreeNode invertTreeUsingIterative(TreeNode root){
        if(root == null){
            return null;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()){
            TreeNode current = stack.pop();

            TreeNode temp = current.left;
            current.left = current.right;
            current.right = temp;

            if(current.left != null){
                stack.push(current.left);
            }
            if(current.right != null){
                stack.push(current.right);
            }
        }
        return root;
    }

    public TreeNode invertTreeUsingRecursion(TreeNode root){
        if(root == null){
            return null;
        }
        //Swap left and right
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        //make recursive call on both left and right
        invertTreeUsingRecursion(root.left);
        invertTreeUsingRecursion(root.right);

        return root;
    }
}
