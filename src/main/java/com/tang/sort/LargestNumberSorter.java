package com.tang.sort;

import static com.tang.sort.QuickSorter.swap;

/**
 * 最大数
 *
 * @author coldtang
 */
public class LargestNumberSorter {
    public static void main(String[] args) {
        int[] data = new int[]{3, 30, 34, 5, 32};
        System.out.println(largestNumber(data));
    }

    public static String largestNumber(int[] nums) {
        sort(nums, 0, nums.length - 1);
        if (nums[0] == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for (int num : nums) {
            sb.append(num);
        }
        return sb.toString();
    }

    /**
     * 降序三路快排
     *
     * @param data
     * @param lo
     * @param hi
     */
    private static void sort(int[] data, int lo, int hi) {
        if (lo >= hi) {
            return;
        }

        int pivot = data[hi];

        int less = lo;
        int great = hi;

        int i = lo;
        while (i <= great) {
            String xy = data[i] + "" + pivot;
            String yx = pivot + "" + data[i];
            if (xy.compareTo(yx) > 0) {
                swap(data, less, i);
                i++;
                less++;
            } else if (xy.compareTo(yx) < 0) {
                swap(data, i, great);
                great--;
            } else {
                i++;
            }
        }

        sort(data, lo, less - 1);
        sort(data, great + 1, hi);
    }
}
