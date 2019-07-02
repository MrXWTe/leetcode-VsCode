/*
 * @lc app=leetcode.cn id=22 lang=java
 *
 * [22] 括号生成
 */
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        helper(res, "", 0, 0, n);
        return res;
    }

    public void helper(List<String> res, String str, int left, int right, int n){
        if(n*2 == str.length()){
            res.add(str);
            return;
        }

        if(left < n){
            helper(res, str+"(", left+1, right, n);
        }
        if(right < left){
            helper(res, str+")", left, right+1, n);
        }
    }
}

