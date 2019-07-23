import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/*
 * @lc app=leetcode.cn id=155 lang=java
 *
 * [155] 最小栈
 */
class MinStack {

    Deque<Element> stack;
    int min = Integer.MAX_VALUE;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new ArrayDeque<>();
    }
    
    public void push(int x) {
        min = Math.min(min, x);
        Element e = new Element(x, min);
        stack.push(e);
    }
    
    public void pop() {
        stack.pop();
        if(stack.isEmpty()){
            min = Integer.MAX_VALUE;
        }else{
            min = stack.peek().min;
        }
    }
    
    public int top() {
        return stack.peek().val;
    }
    
    public int getMin() {
        return stack.peek().min;
    }
}

class Element{
    int val;
    int min;

    public Element(int val, int min){
        this.min = min;
        this.val = val;
    }
}

class MinStack2 {

    private Stack<Integer> data;
    private Stack<Integer> helper;

    /** initialize your data structure here. */
    public MinStack2() {
        data = new Stack<>();
        helper = new Stack<>();
    }
    
    public void push(int x) {
        data.push(x);
        if(helper.isEmpty() || helper.peek() > x){
            helper.push(x);
        }else{
            helper.push(helper.peek());
        }
    }
    
    public void pop() {
        if(!data.isEmpty()){
            data.pop();
            helper.pop();
        }
    }
    
    public int top() {
        if(!data.isEmpty())
            return data.peek();
        throw new RuntimeException("栈中元素为空，此操作非法");
    }
    
    public int getMin() {
        if(!data.isEmpty())
            return helper.peek();
        throw new RuntimeException("栈中元素为空，此操作非法");
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

