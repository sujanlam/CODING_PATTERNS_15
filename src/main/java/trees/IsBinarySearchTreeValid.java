package trees;

public class IsBinarySearchTreeValid {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(3);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(5);
        root.right.left = null;
        root.right.right = new TreeNode(12);

        System.out.println(isValidBinarySearchTree(root));
    }
    public static boolean isValidBinarySearchTree(TreeNode root) {
        return is_within_bound(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public static boolean is_within_bound(TreeNode node, long lower_bound, long upper_bound) {
        if (node == null) {
            return true; // Base case: null node is valid
        }
        if (node.value <= lower_bound  || node.value >= upper_bound) {
            return false; // Node violates BST bounds
        }
        // Recursively validate left and right subtrees
        return is_within_bound(node.left, lower_bound, node.value)
                && is_within_bound(node.right, node.value, upper_bound);
    }
}
