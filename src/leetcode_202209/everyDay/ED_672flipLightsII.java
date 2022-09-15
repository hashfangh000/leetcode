package leetcode_202209.everyDay;

/**
 * @description: https://leetcode.cn/problems/bulb-switcher-ii/
 * @author: fanghao
 * @create: 2022/9/15
 **/
public class ED_672flipLightsII {
    public int flipLights(int n, int presses) {
        if(presses == 0)
            return 1;
        if(n == 1)
            return 2;
        if(n == 2)
            return presses == 1 ? 3 : 4;
        return presses > 2 ? 8 : presses == 1 ? 4 : 7;
    }
}
