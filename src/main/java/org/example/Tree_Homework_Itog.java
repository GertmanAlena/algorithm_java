package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class Tree_Homework_Itog {
    Node root;
    class Node {
        int value;
        Color color;
        Node leftChild;
        Node rightChild;
    }
    public enum Color {
        RED, BLACK
    }
    public Node find(int value) {
        return find(root, value);
    }
    private Node find(Node node, int value) {
        if (node == null) {
            return null;
        }
        if (node.value == value) {
            return node;
        }
        if (node.value < value) {
            return find(node.rightChild, value);
        }
        return find(node.leftChild, value);
    }

    public boolean insert(int value) {
        if (root == null) {
            root = new Node();
            root.value = value;
            root.color = Color.BLACK;
            return true;
        } else {
            boolean res = insert(root, value);
            root = balance(root);
            root.color = Color.BLACK;
            return res;
        }
    }
    public boolean insert(Node node, int value) {
        if (node.value != value) {
            if (node.value > value) {
                if (node.leftChild == null) {
                    node.leftChild = new Node();
                    node.leftChild.value = value;
                    node.leftChild.color = Color.RED;
                    node.leftChild = balance(node.leftChild);
                } else {
                    insert(node.leftChild, value);

                }
            } else {
                if (node.rightChild == null) {
                    node.rightChild = new Node();
                    node.rightChild.value = value;
                    node.rightChild.color = Color.RED;
                    return true;
                } else {
                    insert(node.rightChild, value);

                }
            }
        }
        return false;
    }
    public Node balance(Node node) {
        Node res = node;
        boolean balance;
        do {
            balance = false;
            if (res.rightChild != null && res.rightChild.color == Color.RED &&
                    (res.leftChild == null || res.leftChild.color == Color.BLACK)) {
                balance = true;
                res = rightSwap(res);
            }
            if (res.leftChild != null && res.leftChild.color == Color.RED &&
                    res.leftChild.leftChild != null && res.leftChild.leftChild.color == Color.RED) {
                balance = true;
                res = leftSwap(res);
            }
            if (res.leftChild != null && res.leftChild.color == Color.RED &&
                    (res.rightChild != null && res.rightChild.color == Color.RED)){
                balance = true;
                colorSwap(res);
            }
        }
        while (balance);
        return res;
    }

    public void colorSwap(Node node){
        node.rightChild.color = Color.BLACK;
        node.leftChild.color = Color.BLACK;
        node.color = Color.RED;
    }
    public Node leftSwap(Node node){
        Node leftChild = node.leftChild;
        Node tempChild = node.rightChild;
        leftChild.rightChild = node;
        node.leftChild = tempChild;
        leftChild.color = node.color;
        node.color = Color.RED;
        return leftChild;
    }
    public Node rightSwap(Node node){
        Node rightChild = node.rightChild;
        Node tempChild = rightChild.leftChild;
        rightChild.leftChild = node;
        node.rightChild = tempChild;
        rightChild.color = node.color;
        node.color = Color.RED;
        return rightChild;
    }


    public static void main(String[] args) {

        final Tree_Homework_Itog tree = new Tree_Homework_Itog();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            while (true){
                try {
                    int value = Integer.parseInt(br.readLine());
                    tree.insert(value);
                    System.out.println("--------------------------------");
                } catch (Exception ignored) {

                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}