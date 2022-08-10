package leetcode_202207;

import java.util.*;

/**
 * @program: leetcode_fh
 * @description: https://leetcode.cn/problems/group-anagrams/
 * @author: fanghao
 * @create: 2022-07-15 10:44
 **/

public class Solution_49groupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (int i = 0; i < strs.length; i++){
            char[] word = strs[i].toCharArray();
            Arrays.sort(word);
            String key = new String(word);
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(strs[i]);
            map.put(key, list);
        }
        return new ArrayList<List<String>>(map.values());
    }

    public static void main(String[] args) {
        Solution_49groupAnagrams solution = new Solution_49groupAnagrams();
        String[] s = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(solution.groupAnagrams(s));
    }
}
