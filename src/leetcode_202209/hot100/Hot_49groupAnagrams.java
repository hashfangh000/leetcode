package leetcode_202209.hot100;

import java.util.*;

/**
 * @description: https://leetcode.cn/problems/group-anagrams/?favorite=2cktkvj
 * @author: fanghao
 * @create: 2022/9/21
 * 字母异位词 分组
 * 字母异位词 表示 同一个单词重新排列后得到的新单词，其中原单词仅用了一次
 * strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
 *，
 *
 **/
public class Hot_49groupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (int i = 0; i < strs.length; i++){
            char[] word = strs[i].toCharArray();
            Arrays.sort(word);
            String key = new String(word);
            // 如果存在，返回其本身，不存在返回new ArrayList
            //key 为word，标记此key组
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(strs[i]);
            map.put(key, list);
        }
        return new ArrayList<List<String>>(map.values());
    }

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> ans = groupAnagrams(strs);
        for (List<String> an : ans) {
            for (String str : an) {
                System.out.print(str + ",");
            }
            System.out.println();
        }
    }
}
