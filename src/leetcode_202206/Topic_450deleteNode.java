package leetcode_202206;

/**
 * @program: leetcode_fh
 * @description: https://leetcode.cn/problems/delete-node-in-a-bst/
 * @author: fanghao
 * @create: 2022-06-02 13:58
 **/

public class Topic_450deleteNode {
    public static  class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    //删除key后 调整树为二叉搜索树，左边 < 中间 < 右边
    //若删除节点左右不为空，选右孩子当父节点
    //若左右有一个不为空，不为空当父节点
    //若左右都为空，直接删除
    //递归向下查找key节点，这里节点值唯一
    //由于是二叉搜索树，利用其性质，减少查找范围
    public TreeNode deleteNode(TreeNode root, int key) {

        if (root == null){
            return root;
        }
        if (root.val > key){
            root.left = deleteNode(root.left, key);
        } else if (root.val < key){
            root.right = deleteNode(root.right, key);
        } else{
            if (root.left == null){
                return root.right;
            } else if (root.right == null){
                return root.left;
            }else if(root.left != null && root.right != null){
                TreeNode node = root.right;
                while (node.left != null){
                    node = node.left;
                }
                node.left = root.left;
                root = root.right;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        Topic_450deleteNode solution = new Topic_450deleteNode();
        TreeNode root = new TreeNode(5);
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(6);
        TreeNode node5 = new TreeNode(7);
        root.left = node1;
        root.right = node4;
        node1.left = node2;
        node1.right = node3;
        node4.right = node5;
        solution.deleteNode(root, 7);
    }
}
