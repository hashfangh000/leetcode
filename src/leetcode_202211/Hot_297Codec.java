package leetcode_202211;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @description: https://leetcode.cn/problems/serialize-and-deserialize-binary-tree/description/
 * @author: fanghao
 * @create: 2022/11/18
 **/
public class Hot_297Codec {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null){
            return "";
        }
        String str = "";
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            if (node == null) {
                str += "null,";

            }else{
                str += node.val + ",";
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }
        return str;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == ""){
            return null;
        }
        Queue<String> datalist = new ArrayDeque<>(Arrays.asList(data.split(",")));
        TreeNode root = new TreeNode(Integer.parseInt(datalist.poll())); //第一个节点
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            String left = datalist.poll();
            String right = datalist.poll();
            if(!left.equals("null")){
                node.left = new TreeNode(Integer.parseInt(left));
                queue.add(node.left);
            }
            if(!right.equals("null")){
                node.right = new TreeNode(Integer.parseInt(right));
                queue.add(node.right);
            }
        }
        return root;
    }
}
