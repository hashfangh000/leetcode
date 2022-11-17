package leetcode_202211;

/**
 * @description: https://leetcode.cn/problems/implement-trie-prefix-tree/description/?favorite=2cktkvj
 * @author: fanghao
 * @create: 2022/11/15
 **/
public class Hot_208Trie {
    class TrieNode {
        boolean val;
        TrieNode[] children = new TrieNode[26];
    }
    private TrieNode root;
    public Hot_208Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode p = root;
        for(char c : word.toCharArray()){
            int i = c - 'a';
            if(p.children[i] == null){
                p.children[i] = new TrieNode();
            }
            p = p.children[i];
        }
        p.val = true;
    }

    public boolean search(String word) {
        TrieNode p = root;
        for (char c : word.toCharArray()){
            int i = c - 'a';
            if(p.children[i] == null){
                return false;
            }
            p = p.children[i];
        }
        return p.val;
    }

    public boolean startsWith(String prefix) {
        TrieNode p = root;
        for (char c : prefix.toCharArray()){
            int i = c - 'a';
            if(p.children[i] == null){
                return false;
            }
            p = p.children[i];
        }
        return true;
    }
}
