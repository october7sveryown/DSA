package com.yash.heaps;

public class Heap {

    private int arr[] = new int[10];
    private int size = 0;

    public void insert(int item){

        if(size == arr.length)
            throw new IllegalArgumentException();

        arr[size++]=item;

        bubbleUp();
    }

    public void remove(){

        if(size == 0)
            throw new IllegalArgumentException();

        arr[0]=arr[--size];

        var index = 0;
        while(index <= size &&
                !isValidParent(index) ){
            var largeChildIndex = getLargeChildIndex(index);
            swap(index, largeChildIndex);
            index = largeChildIndex;
        }
    }

    public int getLargeChildIndex(int index){
        return (getLeftChild(index) > getRightChild(index))
                ? leftChildIndex(index) : rightChildIndex(index);
    }

    private boolean isValidParent(int index){
         return (arr[index] >= getLeftChild(index) && arr[index] >= getRightChild(index));
    }

    private int getLeftChild(int index){
        return arr[leftChildIndex(index)];
    }

    private int getRightChild(int index){
        return arr[rightChildIndex(index)];
    }

    private int leftChildIndex(int index){
        return index * 2 + 1;
    }

    private int rightChildIndex(int index){
        return index * 2 + 2;
    }

    private  void bubbleUp(){
        var index=size - 1;
        while(index > 0 && arr[index] > arr[parent(index)]){
            swap(index, parent(index));
            index = parent(index);
        }
    }

    private void swap(int first, int second){
        var temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    private int parent(int index){
        return (index - 1)/2;
    }
}
