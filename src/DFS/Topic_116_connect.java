package DFS;

import java.util.*;

public class Topic_116_connect {
    public Node connect(Node root) {
        if (root == null){
            return root;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (queue.size() > 0){
            int size = queue.size();
            for (int i = 0; i < size; i++){
                Node node = queue.poll();
                if (i < size - 1){
                    node.next = queue.peek();
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return root;
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        Node node1 = new Node(2);
        Node node2 = new Node(3);
        Node node3 = new Node(4);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = null;
        node2.left = null;
        node2.right = null;
        node3.left = null;
        node3.right = null;
        Topic_116_connect solution = new Topic_116_connect();


        Node res = solution.connect(root);

    }
}
