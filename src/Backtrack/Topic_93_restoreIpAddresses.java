package Backtrack;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * https://leetcode-cn.com/problems/restore-ip-addresses/
 */
public class Topic_93_restoreIpAddresses {
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        int len = s.length();
        if (len < 4 || len > 12){
            return ans;
        }
        Deque<String> path = new ArrayDeque<>(4);
        int splitTimes = 0;
        backtracking(ans, len, splitTimes,0, path, s);
        return ans;
    }

    private void backtracking(List<String> ans, int len, int split,  int begin, Deque<String> path, String s) {
        if (begin == len){
            if (split == 4){
                ans.add(String.join(".", path));
                return;
            }
        }
        if (len - begin < (4 - split) || len - begin > 3 * (4 - split)){
            return;
        }
        for (int i = 0; i < 3; i++){
            if(begin + i >= len){
                break;
            }
            int ipseg = judgeIfIpSeg(s, begin, begin + i);
            if (ipseg != -1){
                path.addLast(ipseg + "");
                backtracking(ans, len, split + 1, begin + i + 1, path, s);
                path.removeLast();
            }
        }
    }

    private int judgeIfIpSeg(String s, int left, int right) {
        int len = right - left + 1;
        if(len > 1 && s.charAt(left) == '0'){
            return -1;
        }
        int res = 0;
        for(int i = left; i <= right; i++){
            res = res * 10 + s.charAt(i) - '0';
        }
        if (res > 255){
            return -1;
        }
        return res;
    }



    public static void main(String[] args) {
        Topic_93_restoreIpAddresses solution = new Topic_93_restoreIpAddresses();
        List<String> ans = solution.restoreIpAddresses("25525511135");
        for (String an : ans) {
            System.out.println(an);
        }

    }
}
