package com.prepared.leetcode.stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 20. 有效的括号
 *
 */
public class Day44ValidBracket20 {

    public static void main(String[] args) {
        Day44ValidBracket20 validBracket20 = new Day44ValidBracket20();
        String s = "()[]{}";
        boolean flag = validBracket20.isValid(s);
        System.out.println(flag);
    }


    /**
     * 通过栈，逐个匹配；如果匹配栈顶元素，则出栈
     *
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        Deque<String> stack = new LinkedList<>();
        for(int i = 0; i < s.length(); i++) {
            if(stack.size() > 0 && match(stack.peek(), Character.toString(s.charAt(i)))) {
                stack.pop();
            } else {
                stack.push(Character.toString(s.charAt(i)));
            }
        }
        return stack.size() == 0;
    }

    public boolean match(String s, String t) {
        if(("(".equals(s) && ")".equals(t) )
                || ("[".equals(s) && "]".equals(t))
                || ("{".equals(s) && "}".equals(t))
        ) {
            return true;
        }
        return false;
    }

}
