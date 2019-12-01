package BinarySearchTree;

public class BinarySearchTree {
    Node root;

    public BinarySearchTree() {

    }

    public BinarySearchTree(Node root) {
        this.root = root;

    }

    public Node insert(Node node, int data) {
        if (root == null) {
            var newNode = new Node(data);
            root = newNode;
            node = root;

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
        Node root = null;
        var binarySearchTree = new BinarySearchTree(root);
        root = binarySearchTree.insert(root, 1);
        root = binarySearchTree.insert(root, 2);
        root = binarySearchTree.insert(root, 3);
        root = binarySearchTree.insert(root, 4);
        root = binarySearchTree.insert(root, 5);
        root = binarySearchTree.insert(root, 6);
        binarySearchTree.inorder(root);


    }

}
