package homework04;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MyTree {

    Node root;
    private int size = 0;

    enum Color {
        Red, Black
    }

    public class Node {
        int value;
        private Color color;
        private Node leftChild;
        private Node rightChild;

        Node() {
            color = Color.Red;
        }

        Node(int value) {
            this.value = value;
            leftChild = null;
            rightChild = null;
            color = Color.Red;
        }

    }

    public boolean add(int value) {

        if (root != null) {
            boolean result = addNode(root, value);
            root = rebalance(root);
            root.color = Color.Black;
            return result;
        } else {
            root = new Node(value);
            root.color = Color.Black;
            return true;
        }
    }

    private boolean addNode(Node node, int value) {
        if (node.value == value)
            return false;
        else {
            if (node.value > value) {
                if (node.leftChild != null) {
                    boolean result = addNode(node.leftChild, value);
                    node.leftChild = rebalance(node.leftChild);
                    return result;
                } else {
                    node.leftChild = new Node();
                    node.leftChild.color = Color.Red;
                    node.leftChild.value = value;
                    return true;
                }
            } else {
                if (node.rightChild != null) {
                    boolean result = addNode(node.rightChild, value);
                    node.rightChild = rebalance(node.rightChild);
                    return result;
                } else {
                    node.rightChild = new Node();
                    node.rightChild.color = Color.Red;
                    node.rightChild.value = value;
                    return true;
                }
            }
        }
    }

    private void colorSwap(Node node) {
        node.rightChild.color = Color.Black;
        node.leftChild.color = Color.Black;
        node.color = Color.Red;
    }

    private Node leftSwap(Node node) {
        Node left = node.leftChild;
        Node between = left.rightChild;
        left.rightChild = node;
        node.leftChild = between;
        left.color = node.color;
        node.color = Color.Red;
        return left;
    }

    private Node rightSwap(Node node) {
        Node right = node.rightChild;
        Node between = right.leftChild;
        right.leftChild = node;
        node.rightChild = between;
        right.color = node.color;
        node.color = Color.Red;
        return right;
    }

    private Node rebalance(Node node) {
        Node result = node;
        boolean needRebalance;
        do {
            needRebalance = false;
            if (result.rightChild != null && result.rightChild.color == Color.Red
                    && (result.leftChild == null || result.leftChild.color == Color.Black)) {
                needRebalance = true;
                result = rightSwap(result);
            }
            if (result.leftChild != null && result.leftChild.color == Color.Red
                    && result.leftChild.leftChild != null && result.leftChild.leftChild.color == Color.Red) {
                needRebalance = true;
                result = leftSwap(result);
            }
            if (result.leftChild != null && result.leftChild.color == Color.Red
                    && result.rightChild != null && result.rightChild.color == Color.Red) {
                needRebalance = true;
                colorSwap(result);
            }
        } while (needRebalance);
        return result;
    }

    public  void printTree() {
        if (root == null) {
            System.out.println("Empty tree");
            return;
        }

        int maxDepth = getMaxDepth(root);
        int numNodes = (int) Math.pow(2, maxDepth) - 1;
        String[][] treeArray = new String[maxDepth][numNodes];
        initializeArray(treeArray);

        populateArray(treeArray, root, 0, 0, numNodes - 1);

        for (int i = 0; i < maxDepth; i++) {
            for (int j = 0; j < numNodes; j++) {
                System.out.print(treeArray[i][j]);
            }
            System.out.println();
        }
    }

    private static int getMaxDepth(Node node) {
        if (node == null) {
            return 0;
        } else {
            int leftDepth = getMaxDepth(node.leftChild);
            int rightDepth = getMaxDepth(node.rightChild);
            return 1 + Math.max(leftDepth, rightDepth);
        }
    }

    private static void initializeArray(String[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = "  ";
            }
        }
    }

    private static void populateArray(String[][] array, Node node, int level, int left, int right) {
        if (node == null) {
            return;
        }

        int middle = (left + right) / 2;
        array[level][middle] = String.format("%2d", node.value);

        populateArray(array, node.leftChild, level + 1, left, middle - 1);
        populateArray(array, node.rightChild, level + 1, middle + 1, right);
    }
}
