package leetcode_202206;

/**
 * @program: leetcode_202206
 * @description: https://leetcode.cn/problems/duplicate-zeros/
 * @author: fanghao
 * @create: 2022/6/17 22:25
 */
public class Topic_1089duplicateZeros {
    public void duplicateZeros(int[] arr) {

        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < arr.length; i++){
            stringBuffer.append(arr[i]);
        }
        String s = stringBuffer.toString().replace("0", "00");
        for (int i = 0; i < arr.length; i++){
            arr[i] = s.charAt(i) - '0';
        }
    }
}