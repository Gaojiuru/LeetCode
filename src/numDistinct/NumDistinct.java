package numDistinct;

class Solution{
    public int numDistinct(String s, String t){
        if(s == null && t == null)
            return 1;
        if(s == null || t == null || s.length() < t.length())
            return 0;
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        for(int i = 0; i < dp.length; i ++)
            dp[i][0] = 1;
        for(int j = 1; j <= t.length(); j ++){
            for(int i = j; i <= s.length(); i ++){
                if(s.charAt(i - 1) == t.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[s.length()][t.length()];
    }
}

public class NumDistinct {
    public static void main(String[] args){
        String s = "rabbbit";
        String t = "rabbit";
        System.out.println(new Solution().numDistinct(s, t));
    }
}
