package BST;

public class BST {
    Node root;

    public BST() {
        root = null;

    }

    private void addLeafPrivate(int data, Node node) {
        if (root == null) {
            root = createLeaf(data);

        } else if (data < node.data) {
            if (node.left != null) {
                addLeafPrivate(data, node.left);

            } else {
                node.left = createLeaf(data);

            }

        } else if (data > node.data) {
            if (node.right != null) {
                addLeafPrivate(data, node.right);

            } else {
                node.right = createLeaf(data);

            }

        } else {
            System.out.println("The data has added to the tree. ");

        }


    }

    private void inorderPrivare(Node node) {
        if (root != null) {
            // In-order traversal
            // Go left
            if (node.left != null) {
                inorderPrivare(node.left);

            }
            // Process current node
            System.out.println(node.data + " ");
            // Go right
            if (node.right != null) {
                inorderPrivare(node.right);

            }

        } else {
            System.out.println("The tree is empty. ");

        }
    }

    public Node createLeaf(int data) {
        var node = new Node(data);
        return node;

    }

    public void addLeaf(int data) {
        addLeafPrivate(data, root);

    }

    public void inorder() {
        inorderPrivare(root);

    }

    public static void main(String[] args) {
        int[] arr = {50, 76, 21, 4, 32, 64, 15, 52, 14, 100, 2, 3, 70, 87, 80};
        var bst = new BST();
        bst.inorder();
        for (int i = 0; i < arr.length; i++) {
            bst.addLeaf(arr[i]);

        }
        bst.inorder();

    }
}
