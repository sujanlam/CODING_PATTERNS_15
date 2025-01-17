package trees;

public class MaxSumOfPathBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(2);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(20);
        root.left.right = new TreeNode(1);
        root.right.right = new TreeNode(25);
        root.right.right.left = new TreeNode(3);
        root.right.right.right = new TreeNode(4);

        System.out.println("Maximum Continuous Path Sum: " + maxPathSum(root));
    }
    private static int max_sum = Integer.MIN_VALUE;

    public static int maxPathSum(TreeNode root) {
        if(root == null){
            return 0;
        }
        int left = Math.max(0, maxPathSum(root.left));
        int right = Math.max(0,maxPathSum(root.right));

        max_sum = Math.max(max_sum, left+right+root.value);

        return root.value+Math.max(left, right);
    }
}


