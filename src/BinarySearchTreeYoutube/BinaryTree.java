package BinarySearchTreeYoutube;

public class BinaryTree<E> {
    public void inorder(Node<E> node) {
        if (node == null) {
            return;

        }
        inorder(node.left);
        System.out.println(node.data + " ");
        inorder(node.right);

    }

    public Node insert(E obj) {
        var newNode = new Node<E>(obj);
        return newNode;

    }

    public static void main(String[] args) {
        var binaryTree = new BinaryTree<Integer>();
        Node root = binaryTree.insert(2);
        root.left = binaryTree.insert(7);
        root.right = binaryTree.insert(5);
        root.left.left = binaryTree.insert(3);
        root.left.right = binaryTree.insert(6);
        root.left.right.left = binaryTree.insert(5);
        root.left.right.right = binaryTree.insert(11);
        root.right.right = binaryTree.insert(9);
        root.right.right.left = binaryTree.insert(4);
        binaryTree.inorder(root);

    }
}
