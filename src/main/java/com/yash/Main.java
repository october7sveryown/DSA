package com.yash;

import com.yash.array.Array;
import com.yash.hashmaps.HashMaps;
import com.yash.hashmaps.HashSet;
import com.yash.hashmaps.HashTableImplementation;
import com.yash.trees.Tree;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Tree myTree = new Tree();
        myTree.insert(7);
        myTree.insert(4);
        myTree.insert(9);
        myTree.insert(1);
        myTree.insert(6);
        myTree.insert(8);
        myTree.insert(10);
        myTree.levelOrderTraversal();
    }
}