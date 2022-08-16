package leetcode_202208;

import java.util.Stack;

/**
 * @description: https://leetcode.cn/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof/
 * @author: fanghao
 * @create: 2022/8/15
 **/
public class Offer_33verifyPostorder {
    /*public boolean verifyPostorder(int[] postorder) {
        Stack<Integer> stack = new Stack<>();//存放当前树中的root
        int root = Integer.MAX_VALUE; //记录当前子树的root
        for(int i = postorder.length - 1; i >= 0; i--) {
            if(postorder[i] > root) return false; //若左边大于当前root 返回false
            while(!stack.isEmpty() && stack.peek() > postorder[i])
                root = stack.pop();
            stack.add(postorder[i]);
        }
        return true;
    }*/
    int end;//判断是否完全遍历
    public boolean verifyPostorder(int[] postorder) {
        if (postorder == null || postorder.length == 1) return true;
        end = postorder.length - 1;
        build(postorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return end < 0;//如果完全遍历，则end < 0;
    }
    private void build(int[] postorder, int min, int max) {
        if (end < 0) return ;//空了，返回
        int rootV = postorder[end];
        if (rootV >= max || rootV <= min) return ;
        end--;
        build(postorder, rootV, max);//右子树
        build(postorder, min, rootV);//左子树
    }
}
