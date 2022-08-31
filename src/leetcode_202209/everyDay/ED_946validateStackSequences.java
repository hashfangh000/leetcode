package leetcode_202209.everyDay;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @description: https://leetcode.cn/problems/validate-stack-sequences/
 * @author: fanghao
 * @create: 2022/8/31
 *
 *  判断栈的进栈和出栈顺序是否一致，
 *  题目描述：给定pushed和popped两个序列，每个序列中的值都不重复，只有当它们可能是在最初空栈上进行的推入 push 和弹出 pop 操作序列的结果时，返回 true；否则，返回 false。
 *
 *  定义一个栈 模拟进栈操作，如果当前栈顶元素是 == 出栈的顺序的元素，当前栈出栈，接着进栈新的元素，如果最终栈为空，则进栈的出栈的顺序是合法的，反之不合法
 *
 *
 **/
public class ED_946validateStackSequences {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> stack = new LinkedList<>();
        int i = 0;
        for (int push : pushed){
            stack.push(push);
            while(!stack.isEmpty() && stack.peek() == popped[i]){
                stack.pop();
                i++;
            }
        }
        return stack.isEmpty();
    }
}
