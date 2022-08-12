package leetcode_202208;

/**
 * @description: https://leetcode.cn/problems/ba-shu-zu-pai-cheng-zui-xiao-de-shu-lcof/
 * @author: fanghao
 * @create: 2022/8/10
 **/
public class Offer_45minNumber {
    public String minNumber(int[] nums) {
        int i = 0;
        String[] strs = new String[nums.length];
        for (int num : nums) {
            strs[i] = "" + num;
            i++;
        }
//        sort_string(s);
        quickSort(strs, 0, strs.length - 1);
        StringBuffer sb = new StringBuffer();
        for(String s : strs)
            sb.append(s);
        return sb.toString();
    }
    void sort_string(String[] s){
        for (int i = 0; i < s.length - 1; i++){
            for(int j = i + 1; j < s.length; j++){
                if(!judge(s[i], s[j])){
                    swap(s, i, j);
                }
            }
        }
    }

    void quickSort(String[] strs, int l, int r){
        if(l >= r) return;
        int i = l, j = r;
        String tmp = strs[i];
        while(i < j) {
            while((strs[j] + strs[l]).compareTo(strs[l] + strs[j]) >= 0 && i < j) j--;
            while((strs[i] + strs[l]).compareTo(strs[l] + strs[i]) <= 0 && i < j) i++;
            tmp = strs[i];
            strs[i] = strs[j];
            strs[j] = tmp;
        }
        strs[i] = strs[l];
        strs[l] = tmp;
        quickSort(strs, l, i - 1);
        quickSort(strs, i + 1, r);

    }
    private void swap(String[] s, int i, int j) {
        String tmp = s[i];
        s[i] = s[j];
        s[j] = tmp;
    }

    //return s > s1
    private boolean judge(String s, String s1) {
        String sample1 = s + s1;
        String sample2= s1 + s;
        int i = 0;
        int len1 = sample1.length();
        while (i < len1){
            int s_1 = sample1.charAt(i);
            int s_2 = sample2.charAt(i);
            if (s_1 > s_2){
                return true;
            }else if(s_1 < s_2){
                return false;
            }else{
                i++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {3,30,34,5,9};
        Offer_45minNumber solution = new Offer_45minNumber();
        System.out.println(solution.minNumber(nums));
    }
}
