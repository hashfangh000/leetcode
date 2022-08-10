package leetcode_202204;

public class Topic_796rotateString {
    public boolean rotateString(String s, String goal) {
        int m = s.length(), n = goal.length();
        if (m != n) {
            return false;
        }
        for (int i = 0; i < n; i++) {
            boolean flag = true;
            for (int j = 0; j < n; j++) {
                if (s.charAt((i + j) % n) != goal.charAt(j)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return true;
            }
        }
        return false;
        //return s.length() == goal.length() && (s + s).contains(goal);
    }


    public static void main(String[] args) {
        String s = "abcde";
        String goal = "cdeab";
        Topic_796rotateString solution = new Topic_796rotateString();
        System.out.println(solution.rotateString(s, goal));
    }
}
