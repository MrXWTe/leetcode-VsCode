import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
 * @lc app=leetcode.cn id=56 lang=java
 *
 * [56] 合并区间
 */
class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1)
            return intervals;   

        //按二维数组第一位排序
		Arrays.sort(intervals, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
        });
        
       List<int[]> list = new ArrayList<>();
       for(int i = 0; i<intervals.length-1; i++){
           if(intervals[i][1] >= intervals[i+1][0]){
                intervals[i+1][0] = intervals[i][0];
                intervals[i+1][1] = Math.max(intervals[i][1], intervals[i+1][1]);
           }else{
               list.add(intervals[i]);
           }
       }

       list.add(intervals[intervals.length - 1]);

       int[][] res = new int[list.size()][2];

       for(int i = 0; i<list.size(); i++){
           res[i][0] = list.get(i)[0];
           res[i][1] = list.get(i)[1];
       }
       return res;
    }
}

