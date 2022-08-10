package DFS;

import java.util.*;

public class Topic_199_rightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null){
            return ans;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++){
                TreeNode node = queue.poll();           //出队列
                if (node.left != null){
                    queue.offer(node.left);
                }
                if (node.right != null){
                    queue.offer(node.right);
                }
                if (i == size - 1){                 //保留每层最后一个元素即可
                    ans.add(node.val);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left=new TreeNode(11);
        root.left.right=new TreeNode(12);
        root.left.right.left=new TreeNode(13);
        root.right=new TreeNode(2);
        root.right.left=new TreeNode(3);
        Topic_199_rightSideView solution = new Topic_199_rightSideView();
        List<Integer> ans = solution.rightSideView(root);
        for (Integer an : ans) {
            System.out.println(an);
        }
    }
}
