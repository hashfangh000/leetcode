package leetcode_202211;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: https://leetcode.cn/problems/house-robber-iii/?favorite=2cktkvj
 * @author: fanghao
 * @create: 2022/11/21
 * 给定二叉树的 root 。返回 在不触动警报的情况下 ，小偷能够盗取的最高金额 。
 * f(o)表示 o节点选中的情况下，o节点的子树上被选择的节点的最大权值和
 * g(o)表示 o节点不被选中的情况下，o节点的子树上被选择的节点的最大权值和
 * l 和 r表示 o的左右孩子
 *
 * 1.o被选中时，o的左右孩子都不能被选中，f(o) = g(l) + g(r)
 * 2.o不被选中时，o的左右孩子可以选中也可以不选中，对于o的具体孩子x，对o的贡献是x被选中和不被选中情况下权值和的较大值，g(o) = max{f(l), g(l)} + max{f(r), g(r)}
 **/
public class Hot_337rob {
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
    Map<TreeNode, Integer> f = new HashMap<TreeNode, Integer>();
    Map<TreeNode, Integer> g = new HashMap<TreeNode, Integer>();

    public int rob(TreeNode root) {
        DFS(root);
        return Math.max(f.getOrDefault(root, 0), g.getOrDefault(root, 0));
    }

    private void DFS(TreeNode node) {
        if (node == null){
            return;
        }
        DFS(node.left);
        DFS(node.right);
        f.put(node, node.val + g.getOrDefault(node.left, 0) + g.getOrDefault(node.right, 0));
        g.put(node, Math.max(f.getOrDefault(node.left, 0), g.getOrDefault(node.left, 0)) +
                Math.max(f.getOrDefault(node.right, 0), g.getOrDefault(node.right, 0)));
    }
}
