package trees;


import java.util.*;

public class BinaryTree {
    public static void printAllNodesByLevels(TreeNode root){
        if(root == null){
            return;
        }

        //Queue for level order traversal
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){
            int levelSize = queue.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode current = queue.poll();
                level.add(current.value);

                if(current.left != null){
                    queue.add(current.left);
                }
                if(current.right != null){
                    queue.add(current.right);
                }
            }

            System.out.println(level);
        }
    }
}
