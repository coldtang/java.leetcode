package com.tang.sort;

import com.sun.scenario.effect.Merge;

import java.util.Arrays;

/**
 * 归并排序
 *
 * @author tang
 */
public class MergeSorter {
    public void sort(int[] data) {
        if (data == null || data.length < 2) {
            return;
        }
        sort(data, 0, data.length - 1);
    }

    /**
     * 给子数组排序
     *
     * @param data
     * @param left
     * @param right
     */
    private void sort(int[] data, int left, int right) {
        if (left == right) {
            return;
        }
        int mid = (left + right) / 2;
        sort(data, left, mid);
        sort(data, mid + 1, right);
        merge(data, left, mid, right);
    }

    /**
     * 合并数组
     *
     * @param data
     * @param left
     * @param mid
     * @param right
     */
    private void merge(int[] data, int left, int mid, int right) {
        int num = right - left + 1;
        int[] tmpdata = new int[num];
        int tmpPos = 0;
        int i = left;
        int j = mid + 1;
        // 当左右两边都有数据的时候
        while (i <= mid && j <= right) {
            if (data[i] <= data[j]) {
                tmpdata[tmpPos++] = data[i++];
            } else {
                tmpdata[tmpPos++] = data[j++];
            }
        }
        
        // 当左边有值，右边没值时
        while (i <= mid) {
            tmpdata[tmpPos++] = data[i++];
        }
        // 当左边没值，右边有值时
        while (j <= right) {
            tmpdata[tmpPos++] = data[j++];
        }
        // 拷贝给原数组
        for (tmpPos = 0; tmpPos < tmpdata.length; tmpPos++) {
            data[left++] = tmpdata[tmpPos];
        }
    }

    public static void main(String[] args) {
        int[] data = new int[]{12, 34, 22, 2, 5, 45, 32};
        new MergeSorter().sort(data);
        System.out.println(Arrays.toString(data));
    }
}
