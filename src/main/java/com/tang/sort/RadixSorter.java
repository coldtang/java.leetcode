package com.tang.sort;

/**
 * 基数排序
 *
 * @author coldtang
 */
public class RadixSorter {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }

        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }

        for (int exp = 1; max / exp > 0; exp *= 10) {
            countSorter(nums, exp);
        }
    }

    /**
     * 计数排序
     *
     * @param data
     */
    private void countSorter(int[] data, int exp) {
        int[] count = new int[10];

        for (int i = 0; i < data.length; i++) {
            int digit = (data[i] / exp) % 10;
            count[digit]++;
        }

        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        int[] output = new int[data.length];
        for (int i = data.length - 1; i >= 0; i--) {
            int digit = (data[i] / exp) % 10;
            int k = count[digit] - 1;
            output[k] = data[i];
            count[digit]--;
        }

        for (int i = 0; i < data.length; i++) {
            data[i] = output[i];
        }
    }
}
