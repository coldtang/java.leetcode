package com.tang.sort;

public class MaximumGap {
    public static void main(String[] args) {

    }

    /**
     * 获取最大间距值
     *
     * @param nums
     * @return
     */
    public static int getMaximumGap(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }

        int min = nums[0];
        int max = nums[0];
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        if (max == min) {
            return 0;
        }

        //排序
        int gap = (int) Math.ceil((double) (max - min) / (nums.length - 1));
        int bucketNum = nums.length;
        Bucket[] buckets = new Bucket[bucketNum];
        for (int i = 0; i < bucketNum; i++) {
            buckets[i] = new Bucket();
        }

        for (int num : nums) {
            int bucketId = (num - min) / gap;
            buckets[bucketId].hasData = true;
            buckets[bucketId].min = Math.min(buckets[bucketId].min, num);
            buckets[bucketId].max = Math.max(buckets[bucketId].max, num);
        }

        //获取最大间距
        int maxGap = 0;
        int preBucketMax = min;
        for (Bucket bucket : buckets) {
            if (!bucket.hasData) {
                continue;
            }
            maxGap = Math.max(maxGap, bucket.min - preBucketMax);
            preBucketMax = bucket.max;
        }

        return maxGap;
    }

    private static class Bucket {
        public boolean hasData = false;
        public int min = Integer.MAX_VALUE;
        public int max = Integer.MIN_VALUE;
    }
}
