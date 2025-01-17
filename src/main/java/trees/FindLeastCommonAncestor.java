package trees;

import java.util.ArrayList;
import java.util.List;

public class FindLeastCommonAncestor {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.right.right.right = new TreeNode(8);
        TreeNode p = root.left.left;
        TreeNode q = root.left.right;

        System.out.println(leastCommonAncestor(root, p, q));
    }

    public static TreeNode leastCommonAncestorOptimized(TreeNode root, TreeNode p, TreeNode q){
        if(root == null || p == root || q == root){
            return null;
        }
        TreeNode left = leastCommonAncestorOptimized(root.left, p, q);
        TreeNode right = leastCommonAncestorOptimized(root.right, p , q);

        if(left != null && right != null){
            return root;
        }
        return left != null ? left: right;
    }

    public static TreeNode leastCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        List<TreeNode> pathForN1 = new ArrayList<>();
        List<TreeNode> pathForN2 = new ArrayList<>();

        //If n1 & n2 don't exist in a path
        if(!findPath(root, pathForN1, p) || !findPath(root, pathForN2, q)){
            return null;
        }

        int i = 0;
        //Iterate through path1 and path2 and see if they match whichever does not return 1 before that.
        for (i = 0; i < pathForN1.size() && i < pathForN2.size(); i++) {
            if(pathForN1.get(i) != pathForN2.get(i)){
                return pathForN1.get(i-1);
            }
        }
        //If both data are same till the end return last element
        return (pathForN1.get(i));
    }

    //Method to check if the path exists or not for the node
    private static boolean findPath(TreeNode root, List<TreeNode> path, TreeNode node) {
        if(root == null){
            return false;
        }
        path.add(root);

        //Run recursively to check if the path exists
        if(root == node || findPath(root.left, path, node) || findPath(root.right, path, node)){
            return true;
        }
        path.remove(path.size() - 1);

        return false;
    }



}
