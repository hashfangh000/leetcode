package leetcode_202205;

import sun.reflect.generics.tree.Tree;

import java.util.*;


public class TraverseTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    /**
     * 先序遍历，非递归
     * @param root
     * @return
     */
    public List<Integer> preOrder(TreeNode root){
        List<Integer> res = new ArrayList<>();
        if (root == null){
            return res;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            res.add(node.val);
            if (node.left != null){
                queue.offer(node.left);
            }if (node.right != null){
                queue.offer(node.right);
            }
        }
        return res;
    }
    public List<Integer> inOrder(TreeNode root){
        List<Integer> res = new ArrayList<>();
        if (root == null){
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.empty() || root != null){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            if(!stack.empty()){
                root = stack.pop();
                res.add(root.val);
                root = root.right;
            }
        }
        return res;
    }
    //后序遍历
    public List<Integer> postOrder(TreeNode root){
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>(); //辅助栈存储 根 - 右 - 左 后序的倒序，在栈里弹出的顺序即后续遍历
        stack1.push(root);
        while(!stack1.empty()){
            //根 左 右 压入stack1，弹出的是根 右 左 压入stack2，在弹出的是左 右 根 这里注意理解
            root = stack1.pop();
            stack2.push(root);
            if (root.left != null){
                stack1.push(root.left);
            }
            if (root.right != null){
                stack1.push(root.right);
            }
        }
        while (!stack2.empty()){
            res.add(stack2.pop().val);
        }
        return res;
    }
    //层次遍历，要用到队列，注意要每一层要用for循环
    public List<Integer> levelOrder(TreeNode root){
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                res.add(node.val);
                if (node.left != null){
                    queue.offer(node.left);
                }
                if (node.right != null){
                    queue.offer(node.right);
                }
            }
        }
        return res;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        TreeNode node1 = new TreeNode(6);
        TreeNode node2 = new TreeNode(10);
        TreeNode node3 = new TreeNode(9);
        TreeNode node4 = new TreeNode(11);
        root.left = node1;
        root.right = node2;
        node2.left = node3;
        node2.right = node4;
        TraverseTree solution = new TraverseTree();
        System.out.println("先序"+solution.preOrder(root));
        System.out.println("中序"+solution.inOrder(root));
        System.out.println("后序"+solution.postOrder(root));
        System.out.println("层次遍历"+solution.levelOrder(root));
    }
}
