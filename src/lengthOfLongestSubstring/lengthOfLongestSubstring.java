package lengthOfLongestSubstring;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public static int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int i = 0, j = 0, l = 0;
        while (j < s.length()) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j));
                j++;
                l = Math.max(l, set.size());
            } else
                set.remove(s.charAt(i++));
        }
        return l;
    }
}

public class lengthOfLongestSubstring {
    public static void main(String[] args) {
        String s = "abbb";
        int l = Solution.lengthOfLongestSubstring(s);
        System.out.print(l);
    }
}
