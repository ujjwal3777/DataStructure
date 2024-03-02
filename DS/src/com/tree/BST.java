package com.tree;

import java.util.*;

public class BST {

    static int idx = 0;

    public static void main(String... args) {
        int[] values = {8, 5, 3, 1, 4, 6, 10, 11, 14};
        Node root = null;
        for (int i = 0; i < values.length; i++) {
            root = createBinaryTree(values[i], root);
        }
        System.out.println("Inorder traversal of data is : ");
        inorder(root);
        System.out.println();
        int x = 7;
        boolean searchResult = binarySearch(x, root);
        System.out.println("================Binary Search===================");
        if (searchResult) {
            System.out.println(x + " is present in the tree");
        } else {
            System.out.println(x + " is not present in the tree");
        }
        int y = 10;
        System.out.println(
            "================Deleting " + y + " from binary tree===================");
        deleteNode(root, y);
        System.out.println("Inorder traversal of data is : ");
        inorder(root);
        System.out.println();
        int z = 10;
        System.out.println(
            "================Deleting " + z + " from binary tree===================");
        deleteNode(root, z);
        System.out.println("Inorder traversal of data is : ");
        inorder(root);
        System.out.println();
        System.out.println("print in range: ");
        printInRange(root, 4, 12);
        System.out.println();
        System.out.println("print root to leaf: ");
        List<Integer> path = new ArrayList<>();
        printroot2Leaf(root, path);
    }

    private static void printroot2Leaf(Node root, List<Integer> path) {
        if (root == null) {
            return;
        }
        path.add(root.data);
        if (root.left == null && root.right == null) {
            printdata(path);
        } else {
            printroot2Leaf(root.left, path);
            printroot2Leaf(root.right, path);
        }
        path.remove(path.size() - 1);
    }

    private static void printdata(List<Integer> path) {
        for (int i = 0; i < path.size(); i++) {
            System.out.print(path.get(i) + "->");
        }
        System.out.println();
    }

    private static void printInRange(Node root, int x, int y) {
        if (root == null) {
            return;
        }
        if (root.data >= x && root.data <= y) {
            printInRange(root.left, x, y);
            System.out.print(root.data);
            printInRange(root.right, x, y);
        } else if (root.data >= y) {
            printInRange(root.left, x, y);
        } else {
            printInRange(root.right, x, y);
        }
    }

    private static Node deleteNode(Node root, int x) {
        if (root == null) {
            System.out.println(x + " not present in the tree");
            return null;
        }
        if (x > root.data) {
            root.right = deleteNode(root.right, x);
        } else if (x < root.data) {
            root.left = deleteNode(root.left, x);
        } else {
            // 1st Case -> when Node is leaf Node
            if (root.left == null && root.right == null) {
                return null;
            }

            // 2nd Case -> when root has only one leaf Node
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }

            // 3rd Case -> when node has both the leaf Node, in this case find inOrderSuccessor of the Node to replace deleted Node
            Node IS = inOrderSuccessor(root.right);
            root.data = IS.data;
            root.right = deleteNode(root.right, IS.data);
        }
        return root;
    }

    private static Node inOrderSuccessor(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    private static boolean binarySearch(int x, Node root) {
        if (root == null) {
            return false;
        }
        if (x == root.data) {
            return true;
        }
        if (x > root.data) {
            return binarySearch(x, root.right);
        } else {
            return binarySearch(x, root.left);
        }
    }

    private static void inorder(Node root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data);
        inorder(root.right);
    }

    private static Node createBinaryTree(int value, Node root) {
        if (root == null) {
            root = new Node(value);
            return root;
        }
        if (value < root.data) {
            root.left = createBinaryTree(value, root.left);
        } else {
            root.right = createBinaryTree(value, root.right);
        }
        return root;
    }

    static class Node {

        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
}
