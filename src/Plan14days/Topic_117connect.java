package Plan14days;


/**
 * https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node-ii/
 */
public class Topic_117connect {
    public Node connect(Node root) {

        if (root == null){
            return root;
        }
        Node current = root;
        while (current != null){
            Node dummy = new Node(0);
            Node pre = dummy;
            while (current != null){
                if (current.left != null){
                    pre.next = current.left;        //dummy = pre => dummy.next = current.left
                    pre = pre.next;
                }
                if (current.right != null){
                    pre.next = current.right;
                    pre = pre.next;
                }
                current = current.next;
            }
            current = dummy.next;
        }
        return root;
    }
    public static void main(String[] args) {
        Node root = new  Node(1);
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
        Topic_117connect solution = new Topic_117connect();


        Node res = solution.connect(root);


    }
}
