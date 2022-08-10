package leetcode_202205;

/**
 * https://leetcode.cn/problems/find-closest-lcci/
 */
public class Topic_mianshi17_11findClosest {
    public int findClosest(String[] words, String word1, String word2) {
        int  len = words.length - 1;
        int index1 = -1, index2 = -1;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++){
            String word = words[i];
            if (word.equals(word1)){
                index1 = i;
            }else if(word.equals(word2)){
                index2 = i;
            }
            if (index1 >= 0 && index2 >= 0){
                min = min > Math.abs(index1 - index2) ? Math.abs(index1 - index2) : min;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        Topic_mianshi17_11findClosest solution = new Topic_mianshi17_11findClosest();
        String[] words = {"I","am","a","student","from","a","university","in","a","city"};
        System.out.println(solution.findClosest(words, "I","student"));
    }
}
