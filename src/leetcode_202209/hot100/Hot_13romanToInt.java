package leetcode_202209.hot100;

/**
 * @description: https://leetcode.cn/problems/roman-to-integer/
 * @author: fanghao
 * @create: 2022/9/2
 *
 * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M
 * 给定一个罗马数字，将其转换成整数。
 *
 * 例如， 罗马数字 2 写做II，即为两个并列的 1 。12 写做XII，即为X+II。 27 写做XXVII, 即为XX+V+II。
 * 小值在大值的左边 做减法
 * 小值在大值的右边 做加法
 *
 **/
public class Hot_13romanToInt {
    public int romanToInt(String s) {
        int res = 0;
        int preSum = getV(s.charAt(0));
        for (int i = 1;i < s.length(); i++){
            int num = getV(s.charAt(i));
            if (preSum < num){          //左边比右边小 减法
                res = res - preSum;
            }else{                      //左边比右边大 加法
                res = res + preSum;
            }
            preSum = num;               //更新左边为当前值
        }
        res = res + preSum;             //最后要加上当前值
        return res;
    }

    private int getV(char ch) {
        switch(ch) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
}
