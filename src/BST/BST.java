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

    private Node getNodePrivate(int data, Node node) {
        if (node != null) {
            if (node.data == data) {
                return node;

            } else {
                if (data < node.data) {
                    return getNodePrivate(data, node.left);

                } else {
                    return getNodePrivate(data, node.right);

                }
            }
        } else {
            return null;

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

    public Node getNode(int data) {
        return getNodePrivate(data, root);

    }

    public int getRootData() {
        if (root != null) {
            return root.data;

        } else {
            return -1000;

        }

    }

    public void printChildren(int data) {
        Node ptr = getNode(data);
        if (ptr != null) {
            System.out.println("Parent node = " + ptr.data + ". ");
            if (ptr.left == null) {
                System.out.println("Left child = null. ");

            } else {
                System.out.println("Left child = " + ptr.left.data + ". ");

            }
            if (ptr.right == null) {
                System.out.println("Right child = null. ");

            } else {
                System.out.println("Right child = " + ptr.right.data + ". ");

            }

        } else {
            System.out.println("Data " + data + " is not in the tree. ");

        }
    }

    public void removeRootMatch() {
        if (root != null) {
            Node delPtr = root;
            int rootData = root.data;
            int smallestInRightSubtree;
            if (root.left == null && root.right == null) {
                root = null;
                delPtr = null;

            } else if (root.left == null && root.right != null) {
                root = root.right;
                delPtr.right = null;
                delPtr = null;
                System.out.println("The root node with data " + rootData + " was deleted. ");
                System.out.println("The new root contains data " + root.data + ". ");

            } else if (root.left != null && root.right == null) {
                root = root.left;
                delPtr.left = null;
                delPtr = null;
                System.out.println("The root node with data " + rootData + " was deleted. ");
                System.out.println("The new root contains data " + root.data + ". ");

            }
            // Case 2 - 2 Children


        }
    }

    public static void main(String[] args) {
        int[] arr = {50, 76, 21, 4, 32, 64, 15, 52, 14, 100, 2, 3, 70, 87, 80};
        var bst = new BST();
        bst.inorder();
        for (int i = 0; i < arr.length; i++) {
            bst.addLeaf(arr[i]);

        }
        bst.inorder();
        System.out.println("Root node ");
        bst.printChildren(bst.getRootData());
        System.out.println("All node ");
        for (int i = 0; i < arr.length; i++) {
            bst.printChildren(arr[i]);

        }


    }

}
