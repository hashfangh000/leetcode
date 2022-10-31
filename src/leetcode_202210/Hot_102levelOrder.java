package leetcode_202210;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @description: https://leetcode.cn/problems/binary-tree-level-order-traversal/
 * @author: fanghao
 * @create: 2022/10/29
 * 二叉树层序遍历，用到队列，Deque 双端对列，可以当作stack用，
 *  看作对列：
 *  入队列：
 *      队首：addFirst(e), offerFirst(e),  队尾：addLast(e), offerLast(e)
 *  出队列：
 *      队首：removeFirst(), pollFirst(), 队尾： removeLast(), pollLast()
 *  获取元素：
 *      队首：getFirst(), peekFirst(),    队尾： getLast(), peekLast()
 **/
public class Hot_102levelOrder {
    public class TreeNode {
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

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        //队列，双端队列为主接口
        Deque<TreeNode> level = new LinkedList<>();
        level.add(root);
        while(!level.isEmpty()){
            int size = level.size();
            List<Integer> curLevel = new ArrayList<>();     //每一层的元素放到curLevel中
            for(int i = 0; i < size;i++){                   //遍历当前层所有元素
                TreeNode node = level.poll();
                curLevel.add(node.val);
                if(node.left != null){
                    level.offer(node.left);
                }
                if(node.right != null){
                    level.offer(node.right);
                }
            }
            res.add(new ArrayList(curLevel));
        }
        return res;
    }
}
