package com.yash.hashmaps;

import java.security.Key;
import java.util.LinkedList;

public class HashTableImplementation {


    private class Entry{
        public int key;
        public String value;

        public Entry(int key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    private LinkedList<Entry>[] myList = new LinkedList[5];

    public void put(int key, String value){
        int index = hash(key);

        //populate with list
        if(myList[index]==null)
            myList[index]=new LinkedList<>();

        //check if there's already an entry @ index
        var bucket = myList[index];
        for(var entry:bucket)
            if(entry.key==key){
                entry.value=value;
                return;
            }

        // if entry's not there
        myList[index].addLast(new Entry(key, value));
    }

    public String get(int key){
        int index = hash(key);
        var bucket = myList[index];
        String s = (getEntry(key) != null) ? getEntry(key).value : null;
        return s;
    }

    public void remove(int key){
        int index = hash(key);
        var bucket = myList[index];
        if(bucket!=null){
            bucket.remove(getEntry(key));
        }
        else{
            throw new IllegalArgumentException();
        }
    }

    private Entry getEntry(int key){
        int index = hash(key);
        var bucket = myList[index];
        if(bucket!=null){
            for(var entry: bucket)
                if(entry.key==key)
                    return entry;
        }
        
        return null;
    }
    
    private int hash(int key){
        return key % myList.length;
    }



}
