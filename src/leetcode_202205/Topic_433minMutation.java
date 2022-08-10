package leetcode_202205;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/minimum-genetic-mutation/
 *
 * @author fanghao on 2022/5/7
 */
public class Topic_433minMutation {
    public int minMutation(String start, String end, String[] bank) {
        Set<String> cnt = new HashSet<String>();
        Set<String> visited = new HashSet<String>();
        char[] keys = {'A', 'C', 'G', 'T'};
        for (String s : bank) {
            cnt.add(s);
        }
        if (start.equals(end)){
            return 0;
        }
        if (!cnt.contains(end)){
            return -1;
        }
        Queue<String> queue = new ArrayDeque<>();
        queue.offer(start);
        visited.add(start);
        int step = 1;
        while (!queue.isEmpty()){
            int sz = queue.size();
            for (int i = 0; i < sz; i++){
                String curr = queue.poll();
                for (int j = 0; j < 8; j++){
                    for (int k = 0; k < 4; k++){
                        if (keys[k] != curr.charAt(j)){
                            StringBuffer sb = new StringBuffer(curr);
                            sb.setCharAt(j, keys[k]);
                            String next = sb.toString();
                            if (!visited.contains(next) && cnt.contains(next)){
                                if (next.equals(end)){
                                    return step;
                                }
                                queue.offer(next);
                                visited.add(next);
                            }
                        }
                    }
                }
            }
            step++;
        }
        return -1;
    }

    public static void main(String[] args) {
        Topic_433minMutation solution = new Topic_433minMutation();
        String[] bank = {"AACCGGTA","AACCGCTA","AAACGGTA"};
        System.out.println(solution.minMutation("AACCGGTT", "AAACGGTA", bank));
    }
}