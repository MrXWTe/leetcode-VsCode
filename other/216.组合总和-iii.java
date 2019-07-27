import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=216 lang=java
 *
 * [216] 组合总和 III
 */
class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> list;
    public List<List<Integer>> combinationSum3(int k, int n) {
        list = new ArrayList<>();
        dfs(k, 1, n);
        return ans;
    }

    private void dfs(int k, int i, int target){
        if(k < 0 || target < 0) return;
        if(k == 0 && target == 0) 
            ans.add(new ArrayList<>(list));
        
        for(int j = i; j <= 9; j++){
            list.add(j);
            dfs(k-1, j+1, target-j);
            list.remove(list.size()-1);
        }
    }
}

