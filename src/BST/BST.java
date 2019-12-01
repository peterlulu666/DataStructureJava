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

    private int findSmallestPrivate(Node node) {
        if (root == null) {
            System.out.println("The tree is empty. ");
            return -1000;

        } else {
            if (node.left != null) {
                return findSmallestPrivate(node.left);

            } else {
                return node.data;

            }
        }

    }

    private void removeNodePrivate(int data, Node parent) {
        if (root != null) {
            if (root.data == data) {
                removeRootMatch();

            } else {
                if (data < parent.data && parent.left != null) {
                    if (parent.left.data == data) {
                        removeMatch(parent, parent.left, true);

                    } else {
                        removeNodePrivate(data, parent.left);

                    }

                } else if (data > parent.data && parent.right != null) {
                    if (parent.right.data == data) {
                        removeMatch(parent, parent.right, false);

                    } else {
                        removeNodePrivate(data, parent.right);

                    }

                } else {
                    System.out.println("The data " + data + " was not found in the tree. ");

                }

            }

        } else {
            System.out.println("The tree is empty. ");

        }
    }

    private void removeRootMatch() {
        if (root != null) {
            Node delPtr = root;
            int rootData = root.data;
            int smallestInRightSubtree;
            // Case 0 - 0 children
            if (root.left == null && root.right == null) {
                root = null;
                delPtr = null;

            }
            // Case 1 - 1 child
            else if (root.left == null && root.right != null) {
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
            else {
                smallestInRightSubtree = findSmallestPrivate(root.right);
                removeNodePrivate(smallestInRightSubtree, root);
                root.data = smallestInRightSubtree;
                System.out.println("The root data containing data " + rootData + " was overwritten with data " + root.data + ". ");

            }
        } else {
            System.out.println("Can not remove root. The tree is empty. ");

        }
    }

    private void removeMatch(Node parent, Node match, boolean left) {
        if (root != null) {
            Node delPtr;
            int matchData = match.data;
            int smallestInRightSubtree;
            // Case 0 - 0 Children
            if (match.left == null && match.right == null) {
                delPtr = match;
                if (left == true) {
                    parent.left = null;

                } else {
                    parent.right = null;

                }
                delPtr = null;
                System.out.println("The node containing data " + matchData + " was removed. ");

            }
            // Case 1 - 1 Child
            else if (match.left == null && match.right != null) {
                if (left == true) {
                    parent.left = match.right;

                } else {
                    parent.right = match.right;

                }
                match.right = null;
                delPtr = match;
                delPtr = null;
                System.out.println("The node containing data " + matchData + " was removed. ");

            } else if (match.left != null && match.right == null) {
                if (left == true) {
                    parent.left = match.left;

                } else {
                    parent.right = match.left;

                }
                match.left = null;
                delPtr = match;
                delPtr = null;
                System.out.println("The node containing data " + matchData + " was removed. ");

            }
            // Case 2 - 2 Children
            else {
                smallestInRightSubtree = findSmallestPrivate(match.left);
                removeNodePrivate(smallestInRightSubtree, match);
                match.data = smallestInRightSubtree;

            }


        } else {
            System.out.println("Can not remove match. The tree is empty. ");

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
        Node node = getNode(data);
        if (node != null) {
            System.out.println("Parent node = " + node.data + ". ");
            if (node.left == null) {
                System.out.println("Left child = null. ");

            } else {
                System.out.println("Left child = " + node.left.data + ". ");

            }
            if (node.right == null) {
                System.out.println("Right child = null. ");

            } else {
                System.out.println("Right child = " + node.right.data + ". ");

            }

        } else {
            System.out.println("Data " + data + " is not in the tree. ");

        }
    }

    public int findSmallest() {
        return findSmallestPrivate(root);

    }

    public void removeNode(int data) {
        removeNodePrivate(data, root);

    }


    public static void main(String[] args) {
        int[] arr = {50, 76, 21, 4, 32, 64, 15, 52, 14, 100, 2, 3, 70, 87, 80};
        var bst = new BST();
        bst.inorder();
        for (int i = 0; i < arr.length; i++) {
            bst.addLeaf(arr[i]);

        }
        bst.inorder();
//        System.out.println("Root node ");
//        bst.printChildren(bst.getRootData());
//        System.out.println("All node ");
//        for (int i = 0; i < arr.length; i++) {
//            bst.printChildren(arr[i]);
//
//        }
        System.out.println("The smallest data in the tree is " + bst.findSmallest() + ". ");
        bst.removeNode(50);
        bst.inorder();


    }

}
