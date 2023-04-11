import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    static int level =0;
    static int levelSum =0;
    public static void main(String[] args) {
        int node[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,7,-1,8,-1,-1,-1};
        int node1[] = {6,7,-1,8,-1,-1,-1};
        Node subTree = BinaryTree1.buildTree(node1);
        BinaryTree1.idx =-1;
        Node test = BinaryTree1.buildTree(node);
        System.out.println("Creating Binar Tree --------------------->");
        System.out.println("root data is : " + test.data );
        System.out.println("Doing PreOrder Traversal of a Binary Tree --------------------------->");
        PredOrder.doPreOrderTraversal(test);
        System.out.println();
        System.out.println("Doing InOrder Traversal of a Binary Tree --------------------------->");
        inOrderTraversal(test);
        System.out.println();
        System.out.println("Doing PostOrder Traversal of a Binary Tree --------------------------->");
        postOrderTravseral(test);
        System.out.println();
        System.out.println("Doing LevelOrder Traversal of a Binary Tree --------------------------->");
        levelOrderTraversal(test);
        System.out.println("Counting total number of nodes in  Binary tree--------------------------->");
        int count = nodeCount(test);
        System.out.println("total number of nodes in binary tree is : " + count);
        System.out.println("Counting Height of Binary tree--------------------------->");
        int height = treeHeight(test);
        System.out.println("Height of tree is : " + height);
        System.out.println("Counting Diametere of Binary tree in nsquare Complexity--------------------------->");
        int diam = diameterNsqreComplex(test);
        System.out.println("Diametre of tree is : " + diam);
        System.out.println("Counting Diametere of Binary tree in N Complexity--------------------------->");
        TreeInfo diamNComplexity = diametreNCOmplexity(test);
        System.out.println("Diametre of tree is : " + diamNComplexity.diametre);
        System.out.println("checking for equality of subtree--------------------------->");
        if (isSubTree(test, subTree)) {
            System.out.println(subTree.data + " is subtree of" + test.data);
        } else {
            System.out.println(subTree.data + " is not subtree of" + test.data);
        }
        System.out.println("sum at Nth Level--------------------------->");
        System.out.println("sum: " + sumAtNthLevel(test,5));
    }

    public static int sumAtNthLevel(Node node, int levels) {
        Queue<Node> sumQueue = new LinkedList<>();
        sumQueue.add(node);
        sumQueue.add(null);
        level++;
        while (!sumQueue.isEmpty()) {
            if(levels == level) {
                while (!sumQueue.isEmpty()) {
                    Node test = sumQueue.remove();
                    if(test != null) {
                        levelSum += test.data;
                    } else {
                        return levelSum;
                    }
                }
            } else {
                while (!sumQueue.isEmpty()) {
                    Node test = sumQueue.remove();
                    if(test != null) {
                        if(test.left != null)
                        sumQueue.add(test.left);
                        if(test.right != null)
                        sumQueue.add(test.right);
                    } else {
                        sumQueue.add(null);
                        break;
                    }
                }
            }
            level ++;
        }
        return 0;
    }
    public static boolean isSubTree(Node tree, Node subTree) {
        if(subTree == null)
            return true;
        if(tree == null)
            return false;
        if(tree.data == subTree.data) {
           if(isIdentical(tree,subTree))
               return true;
        }
       return isSubTree(tree.left,subTree) || isSubTree(tree.right,subTree);
    }

    private static boolean isIdentical(Node tree, Node subTree) {
        if(tree == null && subTree == null)
            return true;
        if (tree == null || subTree== null)
            return false;
        if(tree.data == subTree.data) {
           return isIdentical(tree.left,subTree.left) && isIdentical(tree.right,subTree.right);
        }
        return false;
    }

    public static void inOrderTraversal(Node node) {
        if(node == null)
            return;
        inOrderTraversal(node.left);
        System.out.print(node.data);
        inOrderTraversal(node.right);
    }
    public static void postOrderTravseral(Node node) {
        if(node == null)
            return;
        postOrderTravseral(node.left);
        postOrderTravseral(node.right);
        System.out.print(node.data);

    }
    public static int treeHeight(Node node) {
        if(node == null)
            return 0;
        int leftHeight = treeHeight(node.left);
        int rightHeight = treeHeight(node.right);
         return leftHeight >rightHeight ? leftHeight+1 : rightHeight+1;
    }

    public static int diameterNsqreComplex(Node node) {
        if(node == null)
            return 0;
        int left = diameterNsqreComplex(node.left);
        int right = diameterNsqreComplex(node.right);
        int rootHeight = treeHeight(node.left) + treeHeight(node.right) + 1;
        return Math.max(Math.max(left,right),rootHeight);
    }
    static class TreeInfo {
        int diametre;
        int height;
        TreeInfo(int diametre, int height) {
            this.diametre= diametre;
            this.height = height;
        }
    }
    public static TreeInfo diametreNCOmplexity(Node node) {
        if(node == null) {
            return new TreeInfo(0,0);
        }
        TreeInfo left = diametreNCOmplexity(node.left);
        TreeInfo right = diametreNCOmplexity(node.right);
        int height = Math.max(left.height,right.height) +1;
        int rootDiam = left.height + right.height +1;
        int diam = Math.max(Math.max(left.diametre,right.diametre),rootDiam);
        TreeInfo treeInfo = new TreeInfo(diam,height);
        return treeInfo;
    }
    public static int nodeCount(Node node) {
        if(node == null)
            return 0;
        int left = nodeCount(node.left);
        int right = nodeCount(node.right);
        return left+right+1;
    }

    public static void levelOrderTraversal(Node node) {
        if (node == null) {
            return;
        }
        Queue<Node> queue = new LinkedList();
        queue.add(node);
        queue.add(null);
        while (!queue.isEmpty()) {
           Node data = queue.remove();
           if(data == null) {
               System.out.println();
               if(queue.isEmpty()) {
                   break;
               } else {
                   queue.add(null);
               }
           } else {
               System.out.print(data.data);
               if (data.left != null) {
                   queue.add(data.left);
               }
               if (data.right != null) {
                   queue.add(data.right);
               }
           }
        }
    }
    static class Node {
        int data;
        Node left;
        Node right;
        Node(int data) {
            this.data =data;
            this.left= null;
            this.right = null;
        }
    }
    static class BinaryTree1{
        static int idx =-1;
        public static Node buildTree(int data[]) {
            idx++;
            if(data[idx] == -1) {
                return null;
            }
            Node node = new Node(data[idx]);
            node.left = buildTree(data);
            node.right = buildTree(data);
            return node;
        }
    }

    static class PredOrder {
        public static void doPreOrderTraversal(Node node) {
            if(node == null)
                return;
            System.out.println(node.data);
            doPreOrderTraversal(node.left);
            doPreOrderTraversal(node.right);
        }

    }
}