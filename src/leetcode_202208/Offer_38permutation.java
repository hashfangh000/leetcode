package leetcode_202208;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: https://leetcode.cn/problems/zi-fu-chuan-de-pai-lie-lcof/
 * @author: fanghao
 * @create: 2022/8/22
 **/
public class Offer_38permutation {
    List<String> res;
    boolean[] visited;
    public String[] permutation(String s) {
        res = new ArrayList<>();
        visited = new boolean[s.length()];
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        StringBuffer cur = new StringBuffer();
        backtrack(arr, cur, s.length(), 0);
        String[] result = new String[res.size()];
        for (int i = 0; i < res.size(); i++){
            result[i] = res.get(i);
        }
        return result;
    }

    private void backtrack(char[] arr, StringBuffer cur, int len, int index) {
        if (index == len){
            res.add(cur.toString());
            return;
        }
        for (int i = 0; i < len; i++){
            if ((visited[i]) || (i > 0 && !visited[i - 1] && arr[i] == arr[i - 1])){
                continue;
            }

            visited[i] = true;
            cur.append(arr[i]);
            backtrack(arr, cur, len, index + 1);

            cur.deleteCharAt(cur.length() - 1);
            visited[i] = false;
        }
    }

    public static void main(String[] args) {
        Offer_38permutation solution = new Offer_38permutation();
        String[] s = solution.permutation("aac");
        for (String s1 : s) {
            System.out.println(s1);
        }
    }
}
