import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=349 lang=java
 *
 * [349] 两个数组的交集
 */
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        ArrayList<Integer> list = new ArrayList<>();

        Set<Integer> set = new HashSet<>();

        for(int i : nums1){
            set.add(i);
        }

        for(int i : nums2){
            if(set.contains(i)){
                list.add(i);
                set.remove(i);
            }
        }

        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}

