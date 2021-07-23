package year2021.leetCode;

import java.util.ArrayList;
import java.util.List;


/**
 * LeetCode 155. Min Stack
 * https://leetcode.com/problems/min-stack/
 * 
 * RunTime: 349 ms
 * Memory: 42.1 MB
 * */
public class MinStack {
	private List<Integer> list;
    /** initialize your data structure here. */
    public MinStack() {
        list = new ArrayList<Integer>();
    }
    
    public void push(int val) {
        list.add(val);
    }
    
    public void pop() {
    	if(list.size() > 0)
    		list.remove(list.size()-1);
    }
    
    public int top() {
        return list.get(list.size()-1);
    }
    
    public int getMin() {
    	return list.stream().mapToInt(x->x).min().orElse(0);
    }
	/**
	 * Your MinStack object will be instantiated and called as such:
	 * MinStack obj = new MinStack();
	 * obj.push(val);
	 * obj.pop();
	 * int param_3 = obj.top();
	 * int param_4 = obj.getMin();
	 */
}
