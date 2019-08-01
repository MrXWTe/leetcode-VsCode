import java.util.Stack;

/*
 * @lc app=leetcode.cn id=20 lang=java
 *
 * [20] 有效的括号
 *
 * https://leetcode-cn.com/problems/valid-parentheses/description/
 *
 * algorithms
 * Easy (38.76%)
 * Likes:    945
 * Dislikes: 0
 * Total Accepted:    100K
 * Total Submissions: 256.5K
 * Testcase Example:  '"()"'
 *
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * 
 * 有效字符串需满足：
 * 
 * 
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 
 * 
 * 注意空字符串可被认为是有效字符串。
 * 
 * 示例 1:
 * 
 * 输入: "()"
 * 输出: true
 * 
 * 
 * 示例 2:
 * 
 * 输入: "()[]{}"
 * 输出: true
 * 
 * 
 * 示例 3:
 * 
 * 输入: "(]"
 * 输出: false
 * 
 * 
 * 示例 4:
 * 
 * 输入: "([)]"
 * 输出: false
 * 
 * 
 * 示例 5:
 * 
 * 输入: "{[]}"
 * 输出: true
 * 
 */
class Solution {

    public boolean isValid(String s) {
        char[] stack = new char[s.length() + 1];
        int top = 1;
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack[top++] = c; 
            } else if (c == ')' && stack[--top] != '(') {
                return false;
            } else if (c == ']' && stack[--top] != '[') {
                return false;
            } else if (c == '}' && stack[--top] != '{') {
                return false;
            }
        }
        return top == 1;
    }

    public boolean isValid2(String s) {
        Stack<Integer> stack = new Stack<>();
        for(char c : s.toCharArray()){
            switch(c){
                case '(':{
                    stack.push(1);
                    continue;
                }
                case ')':{
                    if(stack.isEmpty() || stack.peek() != 1)
                        return false;
                    stack.pop();
                    continue;
                }
                case '[':{
                    stack.push(2);
                    continue;
                }
                case ']':{
                    if(stack.isEmpty() || stack.peek() != 2)
                        return false;
                    stack.pop();
                    continue;
                }
                case '{':{
                    stack.push(3);
                    continue;
                }
                case '}':{
                    if(stack.isEmpty() || stack.peek() != 3)
                        return false;
                    stack.pop();
                    continue;
                }
            }
        }
        return stack.isEmpty();
    }
}

