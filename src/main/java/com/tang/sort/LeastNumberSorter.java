package com.tang.sort;

import java.util.Arrays;
import java.util.Comparator;

public class LeastNumberSorter {
    public static void main(String[] args) {
        int[] data = new int[]{3, 30, 34, 5, 32};
        System.out.println(leastNumberSorter(data));
    }

    public static String leastNumberSorter(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String xy = o1 + o2;
                String yx = o2 + o1;
                return xy.compareTo(yx);
            }
        });

        System.out.println(Arrays.toString(strs));

        if (strs[0] == "0") {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for (String num : strs) {
            sb.append(num);
        }
        return sb.toString();
    }
}
