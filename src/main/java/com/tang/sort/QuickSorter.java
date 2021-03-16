package com.tang.sort;

import com.sun.org.apache.bcel.internal.generic.SWAP;

import java.util.Arrays;

/**
 * 快速排序：三路快排
 *
 * @author coldtang
 */
public class QuickSorter {
    public static void main(String[] args) {
        int[] data = new int[]{12, 34, 22, 2, 5, 45, 32};
        sort(data,0,6);
        System.out.println(Arrays.toString(data));
    }

    private static void sort(int[] data, int lo, int hi) {
        if (lo >= hi) {
            return;
        }

        int pivot = data[hi];

        int less = lo;
        int great = hi;

        int i = lo;
        while (i <= great) {
            if (data[i] < pivot) {
                swap(data, less, i);
                i++;
                less++;
            } else if (data[i] > pivot) {
                swap(data, i, great);
                great--;
            } else {
                i++;
            }
        }

        sort(data, lo, less - 1);
        sort(data, great + 1, hi);
    }

    /**
     * 交换值
     *
     * @param data
     * @param i
     * @param j
     */
    public static void swap(int[] data, int i, int j) {
        int tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
    }

}
