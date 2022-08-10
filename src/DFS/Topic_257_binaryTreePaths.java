package DFS;

import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Topic_257_binaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        DFS(ans, "", root);
        return ans;
    }

    private void DFS(List<String> ans, String current, TreeNode root) {
        if (root != null){                                  //判空很关键
            StringBuffer path = new StringBuffer(current);
            path.append(root.val);
            if (root.left == null && root.right == null){   //如果到达根节点，加入结果中
                ans.add(path.toString());
            }else {
                path.append("->");
                DFS(ans, path.toString(), root.left);
                DFS(ans, path.toString(), root.right);
            }
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

        Topic_257_binaryTreePaths solution = new Topic_257_binaryTreePaths();
        List<String> ans = solution.binaryTreePaths(root);
        for (String an : ans) {
            System.out.println(an);
        }
    }
}
