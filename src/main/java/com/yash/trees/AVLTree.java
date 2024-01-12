package com.yash.trees;

public class AVLTree {

    private class Node{
        private Node leftChild;
        private Node rightChild;
        private int value;
        

        public Node(int value){
            this.value=value;
        }
    }

    private Node root;
    public void insert(int value){
       root = insert(root, value);
    }

    Node insert(Node root, int value){
        if(root == null) {
            return new Node(value);
        }

        if(value < root.value)
            root.leftChild=insert(root.leftChild, value);
        else
            root.rightChild=insert(root.rightChild,value);

        return root;
    }
}
