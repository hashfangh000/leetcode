package Plan14days;

public class Topic_844backspaceCompare {
    public boolean backspaceCompare(String s, String t) {
        int i = s.length() - 1, j = t.length() - 1;
        int p = 0, q = 0;
        while (i >=0 || j >=0){
            while (i >= 0){
                if (s.charAt(i) == '#'){
                    p++;
                    i--;
                }else if(p > 0){
                    p--;
                    i--;
                }else{
                    break;
                }
            }
            while (j >= 0){
                if (t.charAt(j) == '#'){
                    q++;
                    j--;
                }else if(q > 0){
                    q--;
                    j--;
                }else{
                    break;
                }
            }
            if (i >= 0 && j >= 0){
                if (s.charAt(i) != t.charAt(j)){
                    return false;
                }
            }else {
                if (i >= 0 || j >= 0){
                    return false;
                }
            }
            i--;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        Topic_844backspaceCompare solution = new Topic_844backspaceCompare();
        System.out.println(solution.backspaceCompare("abcd##", "abc#d#"));
    }
}
