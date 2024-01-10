package com.yash.LinkedLists;

public class LinkedList {

    public Node first;
    public Node last;

    public void addFirst(int value){
        Node myNode = new Node(value);
        if(first == null)
            first = last = myNode;
        else {
            myNode.next = first;
            first = myNode;
        }
    }

    public void addLast(int value){
        Node myNode = new Node(value);
        if(first == null)
            first = last = myNode;
        else {
            last.next = myNode;
            last = myNode;
        }
    }

    public void deleteFirst(){
        if(first.next == null)
            first = last = null;
        else {
            first = first.next;
        }
    }

    public void deleteLast(){
        if(first == last)
            first = last = null;

        var i = first;
        while (i.next.next != null){
            i = i.next;
        }
        last = i;
        i.next = null;
    }

    public int indexOf(int value){
        var i=first;
        var counter = 0;

        while(i.next!=null){
            if(i.value==value) {
                return counter;
            }
            i=i.next;
            counter = counter + 1;
        }

        if(last.value == value)
            return counter;
        return -1;
    }
}
