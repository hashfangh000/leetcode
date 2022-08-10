package DFS;

import java.util.ArrayList;
import java.util.List;

public class Topic_129_sumNumbers {
    public int sumNumbers(TreeNode root) {
//        List<String> ans = new ArrayList<>();
//        DFS(ans, "", root);
//        int result = 0;
//        for (String an : ans) {
//            result += Integer.parseInt(an);
//        }
//        return result;
        return dfs(root, 0);
    }

    private void DFS(List<String> ans, String current, TreeNode root) {
        if (root != null){                                  //判空很关键
            StringBuffer path = new StringBuffer(current);
            path.append(root.val);
            if (isLeafNode(root)){                          //如果到达根节点，加入结果中
                ans.add(path.toString());
            }else {
                DFS(ans, path.toString(), root.left);
                DFS(ans, path.toString(), root.right);
            }
        }
    }
    private boolean isLeafNode(TreeNode node) {
        return node.left == null && node.right == null;
    }

    private int dfs(TreeNode root, int prevSum){
        if (root == null){
            return 0;
        }
        int sum = prevSum * 10 + root.val;              //每向下一层 ， 乘 10
        if (isLeafNode(root)){
            return sum;
        }else {
            return dfs(root.left, sum) + dfs(root.right, sum);
        }
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        root.left = node1;
        root.right = node2;
        node1.right = node3;

        Topic_129_sumNumbers solution = new Topic_129_sumNumbers();
        Integer ans = solution.sumNumbers(root);
        System.out.println(ans);
    }
}
