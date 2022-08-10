package leetcode_202203;

/**
 * https://leetcode-cn.com/problems/multiply-strings/
 */
public class Topic_43multiply {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        String ans = "0";
        int len1 = num1.length(), len2 = num2.length();
        for (int i = len2 - 1; i >= 0; i--){
            StringBuffer currentans = new StringBuffer();
            for (int j = len2 - 1; j > i; j--){
                currentans.append(0);
            }
            int a =  num2.charAt(i) - '0';     //
            int carry = 0;
            for (int j = len1 - 1; j >= 0; j--){
                int b = num1.charAt(j) - '0';
                int product = a * b + carry;
                carry = product / 10;
                currentans.append(product % 10);
            }
            if (carry != 0){
                currentans.append(carry % 10);
            }
            ans = addStrings(ans, currentans.reverse().toString());;
        }
        return ans;
    }

    private String addStrings(String num1, String num2) {
        int i = num1.length() - 1, j = num2.length() - 1, add = 0;
        StringBuffer ans = new StringBuffer();
        while (i >= 0 || j >= 0 || add != 0) {
            int x = i >= 0 ? num1.charAt(i) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j) - '0' : 0;
            int result = x + y + add;
            ans.append(result % 10);
            add = result / 10;
            i--;
            j--;
        }
        ans.reverse();
        return ans.toString();
    }

    public static void main(String[] args) {
        Topic_43multiply soulution = new Topic_43multiply();
//        System.out.println(soulution.multiply("99","99"));

        System.out.println(soulution.addStrings("123456","11112333433"));
    }
}
