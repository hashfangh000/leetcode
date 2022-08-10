package leetcode_202206;

import java.util.HashSet;
import java.util.Set;

/**
 * @program: leetcode_fh
 * @description: https://leetcode.cn/problems/unique-email-addresses/
 * @author: fanghao
 * @create: 2022-06-10 10:02
 **/

public class Topic_929numUniqueEmails {
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for (String email : emails) {
            int i = email.indexOf('@');
            String local = email.substring(0, i).split("\\+")[0];
            local = local.replace(".", "");
            set.add(local);
        }
        return set.size();
    }

    public static void main(String[] args) {
        Topic_929numUniqueEmails solution = new Topic_929numUniqueEmails();
//        String[] emails = {"a@leetcode.com", "b@leetcode.com","c@leetcode.com"};
        String[] emails = {"test.email+alex@leetcode.com", "test.email@leetcode.com"};
        System.out.println(solution.numUniqueEmails(emails));
    }
}
