/*
 * @lc app=leetcode.cn id=697 lang=java
 *
 * [697] 数组的度
 */
class Solution {
    public int findShortestSubArray(int[] nums) {
        if (nums.length == 1) return 1;

        int min = nums[0], max = nums[0];
        for (int num : nums) {
            if (num > max) max = num;
            if (num < min) min = num;
        }

        int len = max - min + 1;
        int[] count = new int[len]; // 记录每个数的个数
        int[] span = new int[len]; // 最大跨度
        int[] firstPos = new int[len]; // 第一次出现的位置

        for (int i = 1; i <= nums.length; i++) {
            // 从1开始, 避免从0开始
            int index = nums[i - 1] - min;
            count[index]++;
            if (firstPos[index] == 0) {
                span[index] = 1; // 跨度至少为1(1个数)
                firstPos[index] = i;
            } else {
                span[index] = i - firstPos[index] + 1;
            }
        }

        int topFreq = 0;  // 出现的最大频数
        for (int c : count)
            topFreq = Math.max(topFreq, c);

        if (topFreq == 1) return 1;

        int res = nums.length;
        for (int i = 0; i < count.length; i++) {
            if (count[i] == topFreq) {
                // 找出出现频率最高的数, 取最小跨度
                res = Math.min(res, span[i]);
            }
        }
        return res;
    }
}

