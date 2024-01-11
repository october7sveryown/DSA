package com.yash;

import com.yash.LinkedLists.LinkedList;
import com.yash.array.Array;
import com.yash.hashmaps.HashMaps;
import com.yash.hashmaps.HashSet;
import com.yash.hashmaps.HashTableImplementation;
import com.yash.trees.Tree;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        LinkedList myList = new LinkedList();
        myList.addLast(10);
        myList.addFirst(5);
        myList.addLast(20);
        myList.addLast(40);
        myList.findMiddle();
    }
}