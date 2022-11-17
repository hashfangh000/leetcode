package leetcode_202211;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @description: https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree/description/?favorite=2cktkvj
 * @author: fanghao
 * @create: 2022/11/16
 *
 *
 * 找树中p,q的最近公共祖先
 * 定义一个Map存储每一个节点的父节点，Map<TreeNode, TreeNode>。
 * 然后从p开始，向上遍历，看看p是不是head，不是的话 将其放入一个新的set1集合中 一直到root,
 * 第二部 从q开始 向上遍历，如果遍历到的一个节点在set1中，就是它们的最近公共祖先，
 * p 和 q都向上找自己的父节点，如果遇到第一个相交的父节点，就是其最近公共祖先
 **/
public class Hot_236lowestCommonAncestor {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Map<TreeNode, TreeNode> fatherMap = new HashMap<>();
        fatherMap.put(root, root);          //root 的父节点是本身
        process(root, fatherMap);

        Set<TreeNode> setp = new HashSet<>();
        TreeNode cur = p;
        //p向上找自己的父节点，并将自己的父节点放入setp中
        while(cur != fatherMap.get(cur)){
            setp.add(cur);
            cur = fatherMap.get(cur);
        }
        setp.add(root);
        while(q != fatherMap.get(q)){
            if(setp.contains(q)){
                return q;
            }
            q = fatherMap.get(q);
        }
        return root;
    }
    //深搜写法
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q){
            return root;
        }
        TreeNode leftTree = lowestCommonAncestor2(root.left, p, q);
        TreeNode rightTree = lowestCommonAncestor2(root.right, p, q);
        if(leftTree != null && rightTree != null){
            return root;
        }
        //左右两棵树，找到p 或者 找到 q返回 不空的，这里不可能会遇到 同时都找到p 和 q ，这种情况在上面if已经处理
        return leftTree != null ? leftTree : rightTree;
    }

    private void process(TreeNode root, Map<TreeNode, TreeNode> fatherMap) {
        if (root == null){
            return;
        }
        //左节点 和 右节点的父节点是root
        fatherMap.put(root.left, root);
        fatherMap.put(root.right, root);
        process(root.left, fatherMap);
        process(root.right, fatherMap);
    }
}
