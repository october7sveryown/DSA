package com.yash.trees;

public class Tree {
    private class Node{
        public int value;
        public Node leftChild;
        public Node rightChild;

        public Node(int value){
            this.value=value;
        }

        @Override
        public String toString(){
            return "Node = "+value;
        }

    }



    Node root;
    private void insert(int value){
        if(root == null){
            root = new Node(value);
            return;
        }

        var current=root;
        while(true){
            if(value < current.value){
                if(current.leftChild==null){
                    current.leftChild = new Node(value);
                    break;
                }
                current = current.leftChild;
            } else {
                if(current.rightChild==null){
                    current.rightChild = new Node(value);
                    break;
                }
                current = current.rightChild;
            }
        }
    }

    public Boolean find(int value){
        var current = root;
            while(current!=null){
                if(value < current.value){
                    current=current.leftChild;
                } else if(value > current.value){
                    current=current.rightChild;
                } else {
                    return true;
                }
            }
        return false;
    }

    public void preOrderTraversal(){
        preOrderTraversal(root);
    }

    public void inOrderTraversal(){
        inOrderTraversal(root);
    }

    public void postOrderTraversal(){
        postOrderTraversal(root);
    }

    private void postOrderTraversal(Node root) {
        if(root==null)
            return;
        postOrderTraversal(root.leftChild);
        postOrderTraversal(root.rightChild);
        System.out.print(root.value + " ");
    }

    //BF PRE-ORDER
    private void preOrderTraversal(Node root){
        if(root == null)
            return;
        System.out.print(root.value + " ");
        preOrderTraversal(root.leftChild);
        preOrderTraversal(root.rightChild);
    }

    //IN-ORDER
    private void inOrderTraversal(Node input){
        if(input==null)
            return;
        inOrderTraversal(input.leftChild);
        System.out.print(input.value+" ");
        inOrderTraversal(input.rightChild);
    }

    public int getHeight(){
        return height(root);
    }

    public int getMin(){
        return min(root);
    }

    private int height(Node root){
        if(root==null)
            return -1;
        if(root.leftChild==null && root.rightChild==null)
            return 0;
        return 1 + Math.max(height(root.leftChild), height(root.rightChild));
    }

    //find minimum BT
    private int min(Node root){
        if(root.rightChild==null && root.leftChild==null)
            return root.value;
        var left = min(root.leftChild);
        var right = min(root.rightChild);

        return Math.min(Math.min(left,right), root.value);
    }

    //find minimum BST
    private int minBST(Node root){
        if(root==null)
            throw new IllegalArgumentException();
        var current = root.leftChild;
        var last = current;
        while(current!=null){
            last=current;
            current=current.leftChild;
        }
        return last.value;
    }

    public boolean equals(Tree tree){
        return equals(root, tree.root);
    }

    private boolean equals(Node first, Node second){
        if(first == null && second == null)
            return true;

        if(first != null && second !=null)
            return first.value==second.value && equals(first.leftChild, second.leftChild)
                    && equals(first.rightChild, first.rightChild);

        return false;
    }

    public void swapRoot(){
        var temp = root;
        root.leftChild = root.rightChild;
        root.rightChild = temp;
    }

    public boolean isBST(){
        return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBST(Node node, int min, int max){
        if(node==null)
            return true;

        if(node.value < min || node.value > max)
            return false;

        return isBST(node.leftChild, min, node.value -1 )
                && isBST(node.rightChild, node.value + 1, max);
    }

    public void distanceAt(int distance){
        distanceAt(root, distance);
    }

    private void distanceAt(Node root, int distance){
        if(root==null)
            System.out.println("Tree is empty");
        if(distance == 0)
            System.out.println(root.value);
        else {
            distance = distance - 1;
            distanceAt(root.leftChild, distance);
            distanceAt(root.rightChild, distance);
        }
    }

    public void levelOrderTraversal(){
        for(int i=0;i<=getHeight();i++)
            distanceAt(i);
    }

    public boolean areSiblings(int value1, int value2){
        return areSiblings(root, value1, value2);
    }

    private boolean areSiblings(Node node, int value1, int value2){
        if(node == null)
            return false;

        if(node.leftChild == null && node.rightChild == null)
            return false;

        if((node.leftChild.value == value1 && node.rightChild.value == value2)
                || (node.leftChild.value == value2 && node.rightChild.value == value1))
            return true;

        return areSiblings(node.leftChild, value1, value2) || areSiblings(node.rightChild, value1, value2);

    }


}
