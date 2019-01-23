package com.parepared.leetCode;


import  java.util.*;
/**
 * leetcode problem 804:
 *
 * International Morse Code defines a standard encoding where each letter is mapped to a series of dots and dashes,
 * as follows: "a" maps to ".-", "b" maps to "-...", "c" maps to "-.-.", and so on.
 *
 * For convenience, the full table for the 26 letters of the English alphabet is given below:
 *
 * [".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.",
 * "--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."]
 */
public class Day05UniqueMorseCodeWords804 {

    public int uniqueMorseRepresentations(String[] words) {
        String code = "[.-,-...,-.-.,-..,.,..-.,--.,....,..,.---,-.-,.-..,--,-.,---,.--.,--.-,.-.,...,-,..-,...-,.--,-..-,-.--,--..]";
        Map<String, String> map = new HashMap<String, String>();
        String[] codes = code.split(",");
        String codeStr = null;
        for(int i = 0; i < codes.length; i++) {
            codeStr = codes[i];
            if(i == 0) {
                codeStr = codes[i].substring(1, codes[i].length());
            }
            if(i == codes.length - 1) {
                codeStr = codes[i].substring(0, codes[i].length() -1);
            }
            map.put(String.valueOf((char)(i+97)), codeStr);
        }
        StringBuilder sb = new StringBuilder();
        List<String> list = new ArrayList<String>();
        for(int j = 0; j < words.length; j++) {
            sb.delete(0, sb.length());
            for(int k = 0; k < words[j].length(); k++) {
                sb.append(map.get(String.valueOf(words[j].charAt(k))));
            }
            list.add(sb.toString());
        }
        int count = 1;
        if(list.size() == 0) {
            count = 0;
            return count;
        }
        String str = null;
        boolean flag = true;
        for(int i = 1; i < list.size(); i++) {
            flag = true;
            str = list.get(i);
            for(int j = i-1; j >= 0; j--) {
                if(str.equals(list.get(j))) {
                    flag = false;
                }
            }
            if(flag) {
                count++;
            }
        }
        return count;
    }
}
