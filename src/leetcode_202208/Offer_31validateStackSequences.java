package leetcode_202208;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @description: https://leetcode.cn/problems/zhan-de-ya-ru-dan-chu-xu-lie-lcof/
 * @author: fanghao
 * @create: 2022/8/19
 **/
public class Offer_31validateStackSequences {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> in = new LinkedList<>();
        int i = 0;
        for (int num : pushed){
            in.push(num);
            while(!in.isEmpty() && in.peek() == popped[i]){
                in.pop();
                i++;
            }
        }
        return in.isEmpty();
    }
}
