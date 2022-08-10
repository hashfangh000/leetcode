package leetcode_202205;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/can-i-win/
 *
 * @author fanghao on 2022/5/23
 */
public class Toic_464canIWin {
    Map<Integer, Boolean> memo = new HashMap<Integer, Boolean>();

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if ((1 + maxChoosableInteger) * (maxChoosableInteger) / 2 < desiredTotal) {
            return false;
        }
        return dfs(maxChoosableInteger, 0, desiredTotal, 0);
    }

    public boolean dfs(int maxChoosableInteger, int usedNumbers, int desiredTotal, int currentTotal) {
        //若没有选过 则进来选数字
        if (!memo.containsKey(usedNumbers)) {
            boolean res = false;        //都选完了 还没有赢的 都不能赢 初始为false
            for (int i = 0; i < maxChoosableInteger; i++) {
                if (((usedNumbers >> i) & 1) == 0) {        //判断((usedNumbers >> i) & 1)是否被访问，没选才进入选择
                    if (i + 1 + currentTotal >= desiredTotal) {
                        res = true;
                        break;
                    }
                    //递归判断 我选完后 对方是不是输了，对方输了，我就赢，
                    //usedNumbers | (1 << i)：将i标记为已访问。
                    if (!dfs(maxChoosableInteger, usedNumbers | (1 << i), desiredTotal, currentTotal + i + 1)) {
                        res = true;
                        break;
                    }
                }
            }
            memo.put(usedNumbers, res);
        }
        return memo.get(usedNumbers);
    }
}