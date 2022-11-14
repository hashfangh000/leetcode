package leetcode_202211;

import java.util.*;

/**
 * @description: https://leetcode.cn/problems/group-anagrams/?favorite=2cktkvj
 * @author: fanghao
 * @create: 2022/11/4
 **/
public class Hot_49groupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(int i = 0; i < strs.length; i++){
            char[] word = strs[i].toCharArray();
            Arrays.sort(word);
            String key = new String(word);

            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(strs[i]);
            map.put(key, list);
        }
        return new ArrayList<>(map.values());
    }
}
