package leetcode_202204;

import sun.reflect.generics.tree.Tree;

import java.util.*;

public class Topic_107levelOrderBottom {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
//        if (root == null){
//            return new ArrayList<List<Integer>>();
//        }
//        Deque<List<Integer>> ans = new LinkedList<>();
//        Queue<TreeNode> queue = new ArrayDeque<>();
//        queue.offer(root);
//        while (!queue.isEmpty()){
//            Deque<Integer> deque = new LinkedList<>();
//            int size = queue.size();
//            for (int i = 0; i < size; i++){
//                TreeNode current = queue.poll();
//                deque.offerLast(current.val);
//                if (current.left != null){
//                    queue.offer(current.left);
//                }
//                if (current.right != null){
//                    queue.offer(current.right);
//                }
//            }
//            ans.addFirst(new ArrayList<>(deque));
//        }
//        return new ArrayList<>(ans);

        List<List<Integer>> levelOrder = new LinkedList<List<Integer>>();
        if (root == null) {
            return levelOrder;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<Integer>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                level.add(current.val);
                if (current.left != null){
                    queue.offer(current.left);
                }
                if (current.right != null){
                    queue.offer(current.right);
                }
            }
            levelOrder.add(0, level);
        }
        return levelOrder;
    }
}
