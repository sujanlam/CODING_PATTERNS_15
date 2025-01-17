package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MaxSumOfContinousPathBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(2);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(20);
        root.left.right = new TreeNode(1);
        root.right.right = new TreeNode(25);
        root.right.right.left = new TreeNode(3);
        root.right.right.right = new TreeNode(4);

        System.out.println("Maximum Continuous Path Sum: " + maxContinuousPathSum(root));
    }

    public static int maxContinuousPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxContinuousPathSum(root.left);
        int right = maxContinuousPathSum(root.right);

        return root.value + Math.max(left, right);
    }
}


