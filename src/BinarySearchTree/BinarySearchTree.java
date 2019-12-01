package BinarySearchTree;

public class BinarySearchTree<E> {
    public Node insert(Node<E> node, E obj) {
        // Create root node
        if (node == null) {
            Node<E> newNode = new Node<E>(obj);
            Node rootNode = newNode;
            return rootNode;

        }
        // Go left
        if (((Comparable<E>) obj).compareTo((E) node.data) < 0) {
            node.left = insert(node.left, obj);

        }
        // Go right
        else if (((Comparable<E>) obj).compareTo((E) node.data) > 0) {
            node.right = insert(node.right, obj);

        }
        return node;

    }

    public void inorder(Node<E> node) {
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
        var binarySearchTree = new BinarySearchTree<Integer>();
        Node root = null;
        root = binarySearchTree.insert(root, 2);
        root = binarySearchTree.insert(root, 7);
        root = binarySearchTree.insert(root, 5);
        root = binarySearchTree.insert(root, 1);
        root = binarySearchTree.insert(root, 6);
        root = binarySearchTree.insert(root, 5);
        root = binarySearchTree.insert(root, 11);
        root = binarySearchTree.insert(root, 9);
        root = binarySearchTree.insert(root, 4);
        binarySearchTree.inorder(root);

    }

}
