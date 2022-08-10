package leetcode_202207;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: leetcode_fh
 * @description: https://leetcode.cn/problems/majority-element-ii/
 * @author: fanghao
 * @create: 2022-07-22 17:29
 **/

public class Solution_229majorityElement {
    public List<Integer> majorityElement(int[] nums) {
        /*List<Integer> ans = new ArrayList<Integer>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)){
                int n = map.get(num);
                map.put(num, ++n);
            }else{
                map.put(num, 1);
            }
        }
        for (Integer key : map.keySet()){
            if (map.get(key) >= nums.length / 3){
                ans.add(map.get(key));
            }
        }
        return ans;*/
        // 创建返回值
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        // 初始化两个候选人candidate，和他们的计票
        int cand1 = nums[0], count1 = 0;
        int cand2 = nums[0], count2 = 0;

        // 摩尔投票法，分为两个阶段：配对阶段和计数阶段
        // 配对阶段
        for (int num : nums) {
            // 投票
            if (cand1 == num) {
                count1++;
                continue;
            }
            if (cand2 == num) {
                count2++;
                continue;
            }

            // 第1个候选人配对
            if (count1 == 0) {
                cand1 = num;
                count1++;
                continue;
            }
            // 第2个候选人配对
            if (count2 == 0) {
                cand2 = num;
                count2++;
                continue;
            }

            count1--;
            count2--;
        }

        // 计数阶段
        // 找到了两个候选人之后，需要确定票数是否满足大于 N/3
        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (cand1 == num) count1++;
            else if (cand2 == num) count2++;
        }

        if (count1 > nums.length / 3) res.add(cand1);
        if (count2 > nums.length / 3) res.add(cand2);

        return res;
    }

    public static void main(String[] args) {
        Solution_229majorityElement solution = new Solution_229majorityElement();
        int[] nums = {3, 2, 3};
        solution.majorityElement(nums);
    }
}
