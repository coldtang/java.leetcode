package com.tang.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * 合并区间
 *
 * @author tang
 */

public class MergeRange {
    public int[][] merge(int[][] intervals) {
        //按照第一个值升序排序
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        //按照判断区间是否重叠
        ArrayList<int[]> outputs = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int[] currinterval = intervals[i];
            if (outputs.isEmpty()) {
                outputs.add(currinterval);
            } else {
                int[] lastinterval = outputs.get(outputs.size() - 1);
                int lastRight = lastinterval[1];
                int currLeft = currinterval[0];
                //比较区间最大值
                if (lastRight < currLeft) {
                    outputs.add(currinterval);
                } else {
                    int currRight = currinterval[1];
                    lastinterval[1] = Math.max(lastRight, currRight);
                }
            }
        }

        return outputs.toArray(new int[outputs.size()][]);
    }
}
