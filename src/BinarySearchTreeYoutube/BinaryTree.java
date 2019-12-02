package BinarySearchTreeYoutube;

public class BinaryTree<E> {
    // In-order traversal
    // Go left
    // Process current node
    // Go right
    public void inorder(Node<E> node) {
        if (node == null) {
            return;

        }
        inorder(node.left);
        System.out.print(node.data + " ");
        inorder(node.right);

    }

    // Pre-order traversal
    // Process current node
    // Go left
    // Go right
    public void preorder(Node<E> node) {
        if (node == null) {
            return;

        }
        System.out.print(node.data + " ");
        preorder(node.left);
        preorder(node.right);

    }

    // Post-order traversal
    // Go left
    // Go right
    // Process current node
    public void postorder(Node<E> node) {
        if (node == null) {
            return;

        }
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.data + " ");

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
        root.left.left = binaryTree.insert(2);
        root.left.right = binaryTree.insert(6);
        root.left.right.left = binaryTree.insert(5);
        root.left.right.right = binaryTree.insert(11);
        root.right.right = binaryTree.insert(9);
        root.right.right.left = binaryTree.insert(4);
        System.out.println("In-order ");
        binaryTree.inorder(root);
        System.out.println("\nPre-order ");
        binaryTree.preorder(root);
        System.out.println("\nPost-order ");
        binaryTree.postorder(root);

    }
}
