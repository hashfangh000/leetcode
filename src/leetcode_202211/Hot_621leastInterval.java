package leetcode_202211;

import java.util.*;

/**
 * @description: https://leetcode.cn/problems/task-scheduler/?favorite=2cktkvj
 * @author: fanghao
 * @create: 2022/11/24
 **/
public class Hot_621leastInterval {
    public static int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (char task : tasks){
            map.put(task, map.getOrDefault(task, 0) + 1);
        }
        //任务有多少个
        int m = map.size();
        List<Integer> nextTask = new ArrayList<Integer>();
        List<Integer> rest = new ArrayList<Integer>();
        Set<Map.Entry<Character, Integer>> entrySet = map.entrySet();
        for (Map.Entry<Character, Integer> entry : entrySet){
            int value = entry.getValue();
            nextTask.add(1);
            rest.add(value);
        }

        int time = 0;
        for(int i = 0; i < tasks.length; ++i){
            ++time;
            int minNextTask = Integer.MAX_VALUE;
            for(int j = 0; j < m; ++j) {
                if (rest.get(j) != 0) {
                    minNextTask = Math.min(minNextTask, nextTask.get(j));
                }
            }
            time = Math.max(time, minNextTask);
            int best = -1;
            for (int j = 0; j < m; ++j){
                if(rest.get(j) != 0 && nextTask.get(j) <= time){
                    if (best == -1 || rest.get(j) > rest.get(best)){
                        best = j;
                    }
                }
            }
            nextTask.set(best, time + n + 1);
            rest.set(best, rest.get(best) - 1);
        }
        return time;
    }
    public static int leastInterval2(char[] tasks, int n) {
        n++;
        int[] cnt = new int[26];
        for (char task : tasks){
            cnt[task - 'A']++;
        }
        //初始化 优先级是0
        int[] prio = new int[26];
        //相同优先级的任务，任务数量多的排在前面，不同优先级的，按照优先级大小排列
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> prio[a] == prio[b] ? cnt[b] - cnt[a] : prio[a] - prio[b]);
        //这里进优先队列后，因为初始化优先级都是0,结果是任务数量多的排在前面
        for(int i = 0; i < 26; ++i){
            if(cnt[i] > 0){
                pq.offer(i);
            }
        }
        int ans = 0;
        int time = 0;
        //遍历队列
        while(pq.size() > 0){
            //
            int i = pq.poll();

            time = Math.max(time, prio[i]);
            ans = Math.max(ans, time);
            if(--cnt[i] > 0){
                prio[i] += n;
                pq.offer(i);
            }
            time++;
        }
        return ans + 1;
    }

    public static void main(String[] args) {
        char[] chars = {'A','A','A','A','A','A','B','C','D','E','F','G'};

        leastInterval2(chars, 2);
    }
}
