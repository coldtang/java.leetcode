package com.tang.january;

import java.util.Stack;

/**
 * 力扣 有效的括号
 *
 * @author tang
 */
public class ValidSymbol {

    public static void main(String[] args) {
        Boolean result = isValid(args[0]);
    }

    public static boolean isValid(String s) {
        if (s.isEmpty()) {
            return true;
        }
        Stack<Character> chars = new Stack<>();
        for (char item : s.toCharArray()) {
            if (item == '(') {
                chars.push(')');
            } else if (item == '[') {
                chars.push(']');
            } else if (item == '{') {
                chars.push('}');
            } else if (chars.isEmpty() || item != chars.pop()) {
                return false;
            }
        }
        return chars.isEmpty();
    }
}
