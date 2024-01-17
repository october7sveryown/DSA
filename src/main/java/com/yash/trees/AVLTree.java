package com.yash.trees;

public class AVLTree {

    private class Node{
        private Node leftChild;
        private Node rightChild;
        private int value;
        private int height;

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

        setHeight(root);
        return balance(root);
    }


    public void calculateDiff(){
         calculateDiff(root);
    }

    private void calculateDiff(Node node){

        if(isLeftHeavy(node)){
            System.out.println(node.value + "is left heavy");
        }

        else if(isRightHeavy(node)){
            System.out.println(node.value + "is right heavy");;
        }

        else {
            System.out.println("tree is perfectly balanced");
        }

    }

    public void balance(){
        balance(root);
    }

    private Node balance(Node node){
        if(isLeftHeavy(node)){
            if(getBalanceFactor(node.leftChild) < 0)
                node.leftChild=leftRotate(node.leftChild);
            return rightRotate(node);
        }
        else if(isRightHeavy(node)){
            if(getBalanceFactor(node.rightChild) > 0)
                node.rightChild=rightRotate(node.rightChild);
            return leftRotate(node);
        }
        return node;
    }

    private Node leftRotate(Node node){
        var newRoot = node.rightChild;
        node.rightChild = newRoot.leftChild;
        newRoot.leftChild = node;

        setHeight(node);
        setHeight(newRoot);

        return newRoot;
    }

    private Node rightRotate(Node node){
        var newRoot = node.leftChild;
        node.leftChild = newRoot.rightChild;
        newRoot.rightChild  = node;

        setHeight(node);
        setHeight(newRoot);

        return newRoot;
    }

    private void setHeight(Node root){
        root.height = Math.max(getHeight(root.leftChild), getHeight(root.rightChild))+1;
    }

    private boolean isLeftHeavy(Node node){
        return getBalanceFactor(node)>1;
    }

    private boolean isRightHeavy(Node node){
        return getBalanceFactor(node)<-1;
    }

    private int getBalanceFactor(Node node){
        return (node == null) ? 0 : (getHeight(node.leftChild) - getHeight(node.rightChild));
    }

    private int getHeight(Node node){
        return (node == null)? -1 : node.height;
    }
}
