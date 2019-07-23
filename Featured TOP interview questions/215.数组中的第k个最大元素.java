/*
 * @lc app=leetcode.cn id=215 lang=java
 *
 * [215] 数组中的第K个最大元素
 */
class Solution {
    public int findKthLargest(int[] nums, int k) {
        //最小堆
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        //当堆中元素小于k时直接push进入即可
        for (int i = 0; i < nums.length; i++) {
            if (minHeap.size() < k) {
                minHeap.add(nums[i]);
            }else {
                if (minHeap.peek() < nums[i]) {
                    minHeap.remove();
                    minHeap.add(nums[i]);
                }
            }
        }
        //返回堆顶元素
        return minHeap.peek();
    }
}

