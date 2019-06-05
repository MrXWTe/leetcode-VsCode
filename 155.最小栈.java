/*
 * @lc app=leetcode.cn id=155 lang=java
 *
 * [155] 最小栈
 */
class MinStack {

    private Stack<Integer> stack1 = null;
    private Stack<Integer> stack2 = null;
    int min;
    /** initialize your data structure here. */
    public MinStack() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
        min = Integer.MAX_VALUE;
    }
    
    public void push(int x) {
        stack1.push(x);
        min = Math.min(min, x);
        stack2.push(min);
    }
    
    public void pop() {
        stack1.pop();
        stack2.pop();
        min = stack2.peek();
    }
    
    public int top() {
        return stack1.peek();
    }
    
    public int getMin() {
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

