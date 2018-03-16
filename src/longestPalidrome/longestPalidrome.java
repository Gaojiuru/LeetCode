package longestPalidrome;

class Solution {
    public static String longestPalindrome(String s) {
        int len = 2 * s.length() + 3;
        char[] str = new char[len];

        str[0] = '@';
        str[len - 1] = '$';
        for(int i = 1; i < len - 1; i ++){
            if((i & 1) != 0)
                str[i] = '#';
            else
                str[i] = s.charAt((i >> 1) - 1);
        }
        int[] P = new int[len];
        int maxlen = 0, id = 0, longest = 1, center = 0;
        for(int i = 1; i < len - 1; i ++){
            P[i] = maxlen > i ? Math.min(P[2 * id - i], maxlen - i) : 1;
            while(str[i + P[i]] == str[i - P[i]])
                P[i] ++;
            if(i + P[i] > maxlen){
                maxlen = i + P[i];
                id = i;
            }
            if(longest < P[i]){
                longest = P[i];
                center = i;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = center + 1 - longest; i < center + longest; i ++){
            if(str[i] != '#')
                sb.append(str[i]);
        }

        return sb.toString();
    }
}

public class longestPalidrome {
    public static void main(String[] args) {
        String s = "babad";
        String str = Solution.longestPalindrome(s);
        System.out.println(str);
        System.out.println(s);
    }
}
