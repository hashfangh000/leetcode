package leetcode_202205;

import java.util.*;

/**
 * https://leetcode.cn/problems/serialize-and-deserialize-binary-tree/
 *
 * @author fanghao on 2022/5/11
 */
public class Topic_297Codec {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    // Encodes a tree to a single string.
    //前序遍历序列化操作，非递归
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
    //递归
//    private String rserialize(TreeNode root, String str) {
//        if (root == null){
//           str += "null,";
//        }else{
//            str += str.valueOf(root.val) + ",";
//            str = rserialize(root.left, str);
//            str = rserialize(root.right, str);
//        }
//
//        return str;
//    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == ""){
            return null;
        }
        Queue<String> datalist = new ArrayDeque<>(Arrays.asList(data.split(",")));
        TreeNode root = new TreeNode(Integer.parseInt(datalist.poll()));
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

    private TreeNode rdeserialize(List<String> datalist) {
        if (datalist.get(0).equals("null")){
            datalist.remove(0);
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(datalist.get(0)));
        datalist.remove(0);
        root.left = rdeserialize(datalist);
        root.right = rdeserialize(datalist);
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left=new TreeNode(4);
        root.right=new TreeNode(2);
        root.right.left=new TreeNode(3);
        root.right.right=null;
        Topic_297Codec solution = new Topic_297Codec();
        System.out.println(solution.serialize(root));
        TreeNode node = solution.deserialize(solution.serialize(root));
    }
}