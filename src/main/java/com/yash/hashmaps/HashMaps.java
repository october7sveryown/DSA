package com.yash.hashmaps;

import java.util.HashMap;
import java.util.Map;

public class HashMaps {

    public Character nonRepeatingCharacter(String input){
        Map<Character,Integer> myMap=new HashMap<Character,Integer>();
        input = input.replaceAll("\\s","");
        var chars=input.toCharArray();
        for(var ch : chars){
            int count = myMap.containsKey(ch) ? 1 : 0;
            myMap.put(ch,count+1);
        }
        for(var ch : chars){
           if(myMap.get(ch)==1)
               return ch;
        }
        return '/';
    }

    public Character firstRepeatingCharacter(String input){
        Map<Character,Integer> myMap=new HashMap<Character,Integer>();
        input = input.replaceAll("\\s","");
        var chars=input.toCharArray();
        for(var ch : chars){
            int count = myMap.containsKey(ch) ? 1 : 0;
            myMap.put(ch,count+1);
        }
        for(var ch : chars){
            if(myMap.get(ch)>1)
                return ch;
        }
        return '/';
    }
}
