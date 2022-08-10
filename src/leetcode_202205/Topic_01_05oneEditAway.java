package leetcode_202205;

public class Topic_01_05oneEditAway {
    public boolean oneEditAway(String first, String second) {
        int lenf = first.length();
        int lens = second.length();
        if (lens - lenf == 1){
            return oneInsert(first, second);
        }else if (lenf - lens == 1){
            return oneInsert(second, first);
        }else if (lenf == lens){
            boolean foundDifference = false;
            for (int i = 0; i < lenf; i++){
                if (first.charAt(i) != second.charAt(i)){
                    if (!foundDifference){  //没有找到不同
                        foundDifference = true;
                    }else{                  //找到不同
                        return false;
                    }
                }
            }
            return true;
        }else {
            return false;
        }

    }

    private boolean oneInsert(String shorter, String longer) {
        int len1 = shorter.length(), len2 = longer.length();
        int index1 = 0, index2 = 0;
        while (index1 < len1 && index2 < len2){
            if (shorter.charAt(index1) == longer.charAt(index2)){
                index1++;
            }
            index2++;
            if (index2 - index1 > 1){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Topic_01_05oneEditAway solution = new Topic_01_05oneEditAway();
        System.out.println(solution.oneEditAway("","b"));
    }
}
