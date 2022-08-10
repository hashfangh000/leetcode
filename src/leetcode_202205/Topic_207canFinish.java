package leetcode_202205;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.cn/problems/course-schedule/
 *
 * @author fanghao on 2022/5/10
 */
public class Topic_207canFinish {
    List<List<Integer>> edges;
    int[] indegree;
    int index = 0;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        edges = new ArrayList<List<Integer>>();
        for (int i = 0; i < numCourses; i++){
            edges.add(new ArrayList<>());
        }
        indegree = new int[numCourses];
        for (int[] info : prerequisites){
            edges.get(info[1]).add(info[0]);
            indegree[info[0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++){
            if (indegree[i] == 0){
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()){
            index++;
            int u = queue.poll();
            for (int v : edges.get(u)){
                indegree[v]--;
                if (indegree[v] == 0){
                    queue.offer(v);
                }
            }
        }
        if (index != numCourses){
            return false;
        }
        return true;
    }
}