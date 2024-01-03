package com.yash.hashmaps;

import java.util.Set;

public class HashSet {

    public Character firstRepeatingChar(String input){
        Set<Character> myInput=new java.util.HashSet<>();
        input=input.replaceAll("\\s","");
        var chars = input.toCharArray();
        for(var ch:chars ){
            if(myInput.contains(ch)){
                return ch;
            } else {
                myInput.add(ch);
            }
        }

        return '/';
    }
}
