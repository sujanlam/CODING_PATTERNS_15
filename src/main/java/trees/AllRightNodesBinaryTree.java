package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AllRightNodesBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = null;
        root.left.left.left = new TreeNode(8);
        root.left.left.right = new TreeNode(9);
        root.left.right.right = null;
        root.left.right.right = new TreeNode(11);
        root.left.left.left = null;
        root.left.left.right = null;
        System.out.println(getALlNodesToRight(root));
    }

    public static List<Integer> getALlNodesToRight(TreeNode root){
        List<Integer> result = new ArrayList<>();

        if(root == null){
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()){
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode current = queue.poll();
                if(i == levelSize - 1){
                    result.add(current.val);
                }
                if(current.left != null){
                    queue.offer(current.left);
                }
                if(current.right != null){
                    queue.offer(current.right);
                }
            }
        }

        return result;
    }
}
