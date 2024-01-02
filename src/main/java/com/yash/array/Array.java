package com.yash.array;

import java.util.Arrays;
import java.util.Optional;
import java.util.OptionalInt;

public class Array {

    int length;
    int array[];
    int count;
    public Array(int length) {
        this.length=length;
        this.count=0;
        this.array = new int[this.length];
    }



    //inserting element
    public void insertItem(int elem){
        if(array.length==this.count){
            int[] newArray = new int[this.count*2];
            for(int i=0;i<array.length;i++)
                newArray[i]=this.array[i];
            this.array=newArray;
        }
        this.array[this.count++]=elem;
    }

    //removing item by index
    public void removeItemAt(int index){
        //check for index
        if(index < 0 || index >= count)
            throw new IllegalArgumentException("Illegal index");
        //shift the elements to left
        for(int i=index;i<count;i++){
            this.array[i]=this.array[i+1];
        }
        count--;
    }

    //fetch item by index
    public int getItemAt(int index){
        if(index>this.length){
            return -1;
        }
        else {
            return this.array[index];
        }
    }

    //get length
    public int getLength(){
        return this.array.length;
    }



    //print array
    public void printArray(){
        System.out.println(Arrays.toString(this.array));
    }
}
