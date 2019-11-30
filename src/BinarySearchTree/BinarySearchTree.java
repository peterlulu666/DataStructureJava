package BinarySearchTree;

public class BinarySearchTree<E> {
    public Node insert(Node node, E obj) {
        if (node == null) {
            Node<E> newNode = new Node<E>(obj);
            return newNode;

        }
        if (((Comparable<E>) obj).compareTo((E) node.data) < 0) {
            node.left = insert(node.left, obj);

        } else if (((Comparable<E>) obj).compareTo((E) node.data) > 0) {
            node.right = insert(node.right, obj);

        }
        return node;

    }

    public void inorder(Node node) {
        if (node == null) {
            return;

        }
        inorder(node.left);
        System.out.println(node.data + " ");
        inorder(node.right);

    }


    public static void main(String[] args) {
        var binarySearchTree = new BinarySearchTree<Integer>();
        Node root = null;
        root = binarySearchTree.insert(root, 8);
        root = binarySearchTree.insert(root, 3);
        root = binarySearchTree.insert(root, 6);
        root = binarySearchTree.insert(root, 10);
        root = binarySearchTree.insert(root, 4);
        binarySearchTree.inorder(root);
    }

}
