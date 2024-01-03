package com.yash;

import com.yash.array.Array;
import com.yash.hashmaps.HashMaps;
import com.yash.hashmaps.HashSet;
import com.yash.hashmaps.HashTableImplementation;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        HashTableImplementation hashTable = new HashTableImplementation();
        hashTable.put(6,"A");
        hashTable.put(11, "A++");
        hashTable.put(8, "C");
        hashTable.put(6,"A-copy");
        hashTable.remove(6);
        hashTable.remove(11);
        System.out.println(hashTable.get(8));
    }
}