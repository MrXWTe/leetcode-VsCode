import java.util.List;

/*
 * @lc app=leetcode.cn id=120 lang=java
 *
 * [120] 三角形最小路径和
 */
class Solution {

    public int minimumTotal(List<List<Integer>> triangle){
        int len = triangle.size();
        int[] dp = new int[len+1];

        for(int i = len - 1; i>=0; i--){
            List<Integer> list = triangle.get(i);
            for(int j = 0; j<list.size(); j++){
                dp[j] = Math.min(dp[j], dp[j+1]) + list.get(j);
            }
        }

        return dp[0];
    }


    public int minimumTotal2(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0){
            return 0;
        }

        
        if(triangle.size() > 1){
            for(int i = triangle.size() - 2; i>=0; i--){
                for(int j = 0; j<triangle.get(i).size(); j++){
                    int res = Math.min(triangle.get(i+1).get(j), 
                                       triangle.get(i+1).get(j+1)) + 
                                       triangle.get(i).get(j);
                    triangle.get(i).set(j, res);
                }
            }
        }
        

        return triangle.get(0).get(0);
    }
}

