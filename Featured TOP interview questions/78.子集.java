import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=78 lang=java
 *
 * [78] 子集
 */
class Solution {
    public List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        lists.add(new ArrayList<Integer>());

        for(int i = 0; i < nums.length; i++){
            int size = lists.size();
            for(int j = 0; j < size; j++){
                List<Integer> list = new ArrayList<>();
                list.addAll(lists.get(j));
                list.add(nums[i]);
                lists.add(list);
            }
        }
        return lists;
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        List<Integer> tempList = new ArrayList<Integer>();
        Arrays.sort(nums);
        sub(list, tempList, nums, 0);
        return list;
    }
    
    public void sub(List<List<Integer>> list, List<Integer> tempList, int[] nums, int i){
        list.add(new ArrayList<Integer>(tempList));
        for(int j = i; j < nums.length; j++){
            tempList.add(nums[j]);
            sub(list, tempList, nums, j + 1);
            tempList.remove(tempList.size() - 1);
        }
        
    }
}

