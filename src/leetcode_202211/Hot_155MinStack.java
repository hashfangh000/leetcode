package leetcode_202211;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @description: https://leetcode.cn/problems/min-stack/?favorite=2cktkvj
 * @author: fanghao
 * @create: 2022/11/15
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * 实现 MinStack 类:
 *
 * MinStack() 初始化堆栈对象。
 * void push(int val) 将元素val推入堆栈。
 * void pop() 删除堆栈顶部的元素。
 * int top() 获取堆栈顶部的元素。
 * int getMin() 获取堆栈中的最小元素。
 *
 * 定义两个栈，第一个正常进出，第二个表示栈顶为a时，的最小元素
 *  初始化时 将stack2底部加入最大元素，实际上stack1.size + 1 = stack2.size
 **/
public class Hot_155MinStack {
    Deque<Integer> stack1, stack2;

    public Hot_155MinStack() {
        stack1 = new LinkedList<>();
        stack2 = new LinkedList<>();
        stack2.push(Integer.MAX_VALUE);
    }

    public void push(int val) {
        stack1.push(val);
        stack2.push(Math.min(stack2.peek(), val));
    }

    public void pop() {
        stack1.pop();
        stack2.pop();
    }

    public int top() {
        return stack1.peek();
    }

    public int getMin() {
        return stack2.peek();
    }
}
