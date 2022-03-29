package tasks.nodes;

import java.util.*;

public class Tree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);

        root.left = new TreeNode(1);

        root.right = new TreeNode(2);


        List<Integer> dfs = dfs(root);

        for (int b = 0; b < dfs.size(); b++) {
            System.out.print(dfs.get(b) + " ");

        }
    }

    public static List<Integer> dfs(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        List<Integer> result = new ArrayList<>();
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);

            if(node.right != null) {
                stack.push(node.right) ;
            }
            if(node.left != null) {
                stack.push(node.left);
            }
        }
        return result;
    }

    public static List<Integer> bfs(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        List<Integer> result = new ArrayList<>();
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            result.add(node.val);

            if(node.right != null) {
                queue.add(node.right) ;
            }
            if(node.left != null) {
                queue.add(node.left);
            }
        }
        return result;
    }



    static class TreeNode {
        int val;
        TreeNode right;
        TreeNode left;

        public TreeNode(int val) {
            this.val = val;

        }
    }

}
