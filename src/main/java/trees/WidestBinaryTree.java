package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Node {
    TreeNode node;
    int index;

    Node(TreeNode node, int index){
        this.node = node;
        this.index = index;
    }

}

public class WidestBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = null;
        root.right.right = new TreeNode(7);
        root.left.left.left = new TreeNode(8);
        root.left.left.right = new TreeNode(9);
        root.left.right.right = null;
        root.left.right.right = new TreeNode(11);
        root.right.right.left = new TreeNode(14);

        System.out.println(getALlNodesToRight(root));
    }

    public static int getALlNodesToRight(TreeNode root){
        int max_width = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(root, 0));
        while (!queue.isEmpty()){
            int levelSize = queue.size();
            int start = 0;
            int end = 0;

            for (int i = 0; i < levelSize; i++) {
                Node current = queue.poll();
                int index = current.index;

                if(i == 0){
                    start = index;
                }
                if(i == levelSize-1){
                    end = index;
                }
                if(current.node.left != null){
                    queue.offer(new Node(current.node.left, 2*current.index));
                }
                if(current.node.right != null){
                    queue.offer(new Node(current.node.right, 2*current.index+1));
                }
            }
            max_width = Math.max(max_width, end-start+1);
        }
        return max_width;
    }
}
























/*
if (root == null) {
            return 0;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(root, 0));
        int maxWidth = 0;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            int start = 0;
            int end = 0;
            for (int i = 0; i < levelSize; i++) {

                Node current = queue.poll();
                int index = current.index;

                if(i == 0){
                    start = index;
                }
                if(i== levelSize-1){
                    end = index;
                }
                if (current.node.left != null) {
                    queue.offer(new Node(current.node.left, 2*current.index));
                }
                if(current.node.right != null){
                    queue.offer(new Node(current.node.right, 2* current.index+1));
                }
            }
            maxWidth = Math.max(maxWidth, end-start+1);
        }

        return maxWidth;*/