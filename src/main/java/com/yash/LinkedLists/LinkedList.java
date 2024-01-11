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

    public void reverse(){
        if(first==null) return;

       var current = first.next;
       var previous = first;
       while(current!=null){
           var next = current.next;
           current.next = previous;
           previous = current;
           current = next;
       }
        last = first;
        last.next = null;
        first = previous;
    }

    public int findKthNodeFromEnd(int k){

        if(first == null){
            throw new IllegalArgumentException();
        }

        var p1 = first;
        var p2 = first;
        for(int i=0; i<k-1; i++){
            p2 = p2.next;
            if(p2==null)
                throw new IllegalArgumentException();
        }

        while(p2!=last){
            p1=p1.next;
            p2=p2.next;
        }
        return p1.value;
    }

    public void findMiddle(){
        var a = first;
        var b = first;
        while(b!=last && b.next!=last){
            a=a.next;
            b=b.next.next;
        }
        if(b==last){
            System.out.println(a.value);
        } else {
            System.out.println(a.value + " "+ a.next.value);
        }
    }
}
