/*
 * @lc app=leetcode.cn id=31 lang=java
 *
 * [31] 下一个排列
 */
class Solution {
    public void nextPermutation(int[] nums) {
        // 长度小于1的数组
        if(nums == null || nums.length <= 1)
            return;
    
        // 从后向前找到第一个非逆序的数
        int i = nums.length - 2; 
        for(; i >= 0 && nums[i] >= nums[i + 1]; --i);

        //从i+1位置开始，向后查找比nums[i]大的最小元素
        if(i >= 0){ 
            int j = i + 1;
            for(; j < nums.length && nums[j] > nums[i]; ++j);
            swap(nums,i,j - 1); //交换，注意是同 j - 1交换
        }

        //逆序之后的数
        int k = nums.length - 1;
        i++;
        for(; i < k; i++, k--)
            swap(nums, i, k);
    }

     /* 交换元素
     * @param array
     * @param i
     * @param j
     */
    public void swap(int[] array,int i ,int j){
        //交换
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}

