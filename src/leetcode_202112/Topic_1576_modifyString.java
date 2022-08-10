package leetcode_202112;

public class Topic_1576_modifyString {
    public String modifyString(String s) {
        int n = s.length();
        char[] ch = s.toCharArray();
        for (int i = 0; i < n; i++){
            if (ch[i] == '?'){
                for (char c = 'a'; c <= 'c'; c++){                  //遍历三个互不相同的字符串即可满足
                    if ((i > 0 && ch[i - 1] == c) || (i < n - 1 && ch[i + 1] == c)){
                        continue;
                    }
                    ch[i] = c;
                    break;
                }
            }
        }
        return new String(ch);
    }
}
