package leetcode_202204;

import java.util.*;

public class Topic_103zigzagLevelOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null){
            return new ArrayList<List<Integer>>();
        }
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        boolean isOrderLeft = true;
        queue.offer(root);
        while (!queue.isEmpty()){
            Deque<Integer> levelList = new LinkedList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++){
                TreeNode current = queue.poll();
                if (isOrderLeft){
                    levelList.offerLast(current.val);
                }else{
                    levelList.offerFirst(current.val);
                }
                if (current.left != null){
                    queue.offer(current.left);
                }
                if (current.right != null){
                    queue.offer(current.right);
                }
            }
            ans.add(new LinkedList<Integer>(levelList));
            isOrderLeft = !isOrderLeft;
        }
        return ans;
    }
}
