package BinarySearchTree;

public class BinarySearchTree {
    Node root = null;

    public BinarySearchTree() {

    }

    public BinarySearchTree(Node root) {
        this.root = root;

    }

    public Node insert(Node node, int data) {
        if (this.root == null) {
            var newNode = new Node(data);
            this.root = newNode;
            node = this.root;

        } else if (data < node.data) {
            if (node.left != null) {
                insert(node.left, data);

            } else {
                var newNode = new Node(data);
                node.left = newNode;

            }
        } else if (data > node.data) {
            if (node.right != null) {
                insert(node.right, data);

            } else {
                var newNode = new Node(data);
                node.right = newNode;

            }
        } else {
            System.out.println("The data has been added to the tree. ");

        }

        return node;

    }

    public void inorder(Node node) {
        if (node == null) {
            return;

        }
        // In-order traversal
        // Go left
        inorder(node.left);
        // Process current node
        System.out.println(node.data + " ");
        // Go right
        inorder(node.right);

    }

    public static void main(String[] args) {
        int[] arr = {50, 76, 21, 4, 32, 64, 15, 52, 14, 100, 2, 3, 70, 87, 80};
        Node root = null;
        var binarySearchTree = new BinarySearchTree(root);
        for (int i = 0; i < arr.length; i++) {
            root = binarySearchTree.insert(root, arr[i]);

        }
        binarySearchTree.inorder(root);


    }

}
