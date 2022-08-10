package leetcode_202112;

import java.util.HashSet;
import java.util.Set;

public class Topic_141_hasCycle {
    public boolean hasCycle(ListNode head) {
        /**
         * Set 集合  不含有重复元素
         */
        Set<ListNode> set = new HashSet<>();
        while (head != null){
            if(!set.add(head)){
                return true;
            }
            head = head.next;
        }
        return false;
    }
}
