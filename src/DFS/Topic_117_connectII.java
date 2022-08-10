package DFS;

import java.util.LinkedList;
import java.util.Queue;

public class Topic_117_connectII {
    public Node connect(Node root) {
        if (root == null){
            return root;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (queue.size() > 0){
            int size = queue.size();
            Node last = null;
            for (int i = 1; i <= size; i++){
                Node node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                if (i != 1){
                    last.next = node;
                }
                last = node;
            }
        }
        return root;
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        Node node1 = new Node(2);
        Node node2 = new Node(3);
        Node node3 = new Node(4);
        Node node4 = new Node(5);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = null;
        node2.left = null;
        node2.right = node4;
        node3.left = null;
        node3.right = null;
        Topic_117_connectII solution = new Topic_117_connectII();


        Node res = solution.connect(root);

    }
}
