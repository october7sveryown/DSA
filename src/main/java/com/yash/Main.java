package com.yash;

import com.yash.array.Array;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Array myArray = new Array(5);
        System.out.println(myArray.getLength());
        myArray.insertItem(10);
        myArray.insertItem(20);
        myArray.insertItem(30);
        myArray.insertItem(40);
        myArray.insertItem(50);
        myArray.insertItem(60);
        myArray.removeItemAt(1);
        int ars[] = myArray.reverse();
        for(int i=0;i<ars.length;i++){
            System.out.println(ars[i]);
        }
        myArray.printArray();
    }
}