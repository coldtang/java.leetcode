package com.tang.january;

import com.sun.javafx.image.BytePixelSetter;
import com.sun.org.apache.xpath.internal.operations.Equals;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 力扣 第一百二十五题
 *
 * @author tang
 */
public class IsPalindrome {
    public static void main(String[] args) {
        boolean aaa = isPalindrome("A man, a plan, a canal: Panama");
        System.out.printf(String.valueOf(aaa));
    }

    private static boolean isPalindrome(String s) {
        if (s == null && s.length() == 0) {
            return false;
        }
        s = s.toLowerCase();
        StringBuilder sb = new StringBuilder();
        for (char item : s.toCharArray()) {
            if ((item >= '0' && item <= '9') || (item >= 'a' && item <= 'z')) {
                sb.append(item);
            }
        }
        char[] chars = sb.toString().toCharArray();
        int j = chars.length - 1;
        for (int i = 0; i < chars.length; i++) {
            if (i >= j) {
                break;
            }
            if (chars[i] != chars[j]) {
                return false;
            }
            j--;
        }

        return true;
    }
}
