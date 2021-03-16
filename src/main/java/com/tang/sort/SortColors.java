package com.tang.sort;

/**
 * 75. 颜色分类(计数排序)
 *
 * @author coldtang
 */
public class SortColors {
    public void sortColors(int[] nums) {
        int[] count = new int[3];
        for (int num : nums) {
            count[num]++;
        }
        int k = 0;
        for (int i = 0; i <= 2; i++) {
            int num = count[i];
            for (int j = 0; i < num; j++) {
                nums[k] = i;
                k++;
            }
        }
    }
}
