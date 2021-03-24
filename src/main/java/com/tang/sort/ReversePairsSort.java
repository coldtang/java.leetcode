package com.tang.sort;

/**
 * 数组中的逆序对
 *
 * @author coldtang
 */
public class ReversePairsSort {
    /**
     * 数组中的逆序对
     *
     * @param nums
     * @return
     */
    public int reversePairs(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }

        int[] copy = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            copy[i] = nums[i];
        }

        return getReversePairsCount(copy, 0, copy.length - 1);
    }

    /**
     * 分区计算
     *
     * @param data
     * @param left
     * @param right
     * @return
     */
    private int getReversePairsCount(int[] data, int left, int right) {
        if (left >= right) {
            return 0;
        }
        int mid = (left + right) / 2;
        int leftCount = getReversePairsCount(data, left, mid);
        int rightCount = getReversePairsCount(data, mid + 1, right);
        int count = merge(data, left, mid, right);

        return leftCount + rightCount + count;
    }

    /**
     * 合并数组并计算逆序对
     *
     * @param data
     * @param left
     * @param mid
     * @param right
     * @return
     */
    private int merge(int[] data, int left, int mid, int right) {
        int num = right - left + 1;
        int[] tmpdata = new int[num];
        int tmpPos = 0;
        int i = left;
        int j = mid + 1;
        int count = 0;
        // 当左右两边都有数据的时候
        while (i <= mid && j <= right) {
            if (data[i] <= data[j]) {
                tmpdata[tmpPos++] = data[i++];
            } else {
                count += mid - i + 1;
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

        return count;
    }
}
