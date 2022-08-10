package leetcode_202112;

import java.util.*;

public class Topic_748_shortestCompletingWord {

    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] cnt = new int[26];
        for (int i = 0; i < licensePlate.length(); i++){
            char c = licensePlate.charAt(i);
            if (Character.isLetter(c)){
                ++cnt[Character.toLowerCase(c) - 'a'];
            }
        }
        int index = -1;
        for(int i = 0; i < words.length; i++){
            int[] c = new int[26];
            for(int j = 0; j < words[i].length(); j++){
                char ch = words[i].charAt(j);
                ++c[ch - 'a'];
            }
            boolean ok = true;
            for (int j = 0; j < 26; j++){
                if(cnt[j] > c[j]){
                    ok = false;
                    break;
                }
            }
            if (ok && (index < 0 || words[i].length() < words[index].length())){
                index = i;
            }
        }
        return words[index];
    }

    public static void main(String[] args) {
        Topic_748_shortestCompletingWord solution = new Topic_748_shortestCompletingWord();
        System.out.println(solution.shortestCompletingWord("1s3 PSt",new String[]{"step", "steps", "stripe", "stepple"}));
    }
}
