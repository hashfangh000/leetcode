package leetcode_202208;

/**
 * @description: https://leetcode.cn/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof/
 * @author: fanghao
 * @create: 2022/8/19
 **/
public class Offer_62lastRemaining {


    public int lastRemaining(int n, int m) {
        /*
        第一次，【0, 1, 2, 3, 4】，本轮要踢出2                                  看3
        (下一轮开始从3计数，为了方便读者看出规律，将开始计数的那一位移到开头)
        第二次，【3, 4, 0, 1】，本轮要踢出0                                     看1
        第三次，【1, 3, 4】，本轮要踢出4                                        看1
        第四次，【1, 3】 本轮要踢出1                                            看3
        第五次，【3】
        最后返回3
         */
        int f = 0;  //结果肯定在0位置，只剩最后一个元素
        for(int i = 2; i <= n; i++){
            f = (m + f) % i;  //i从2开始是因为：上一状态长度为2
        }
        return f;
    }
}
