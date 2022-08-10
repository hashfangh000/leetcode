package leetcode_202205;

public class Topic_944minDeletionSize {
    public int minDeletionSize(String[] strs) {
        int res = 0;
        for (int j = 0; j < strs[0].length(); j++){
            for (int i = 0; i < strs.length - 1; i++){
                if(strs[i].charAt(j) > strs[i + 1].charAt(j)){
                    res++;
                    break;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Topic_944minDeletionSize solution = new Topic_944minDeletionSize();
        System.out.println(solution.minDeletionSize(new String[]{"cba","daf","ghi"}));
        System.out.println(solution.minDeletionSize(new String[]{"a","b","c"}));
        System.out.println(solution.minDeletionSize(new String[]{"zyx","wvu","tsr"}));

    }
}
