package isInterleave;

class Solution{
    public boolean isinterleave(String s1, String s2, String s3){
        if(s3.length() != s1.length() + s2.length())
            return false;
        boolean[][] res = new boolean[s1.length() + 1][s2.length() + 1];
        for(int i = 0; i <= s1.length(); i ++)
            for(int j = 0; j <= s2.length(); j ++){
                if(i == 0 && j == 0)
                    res[i][j] = true;
                else if(i == 0)
                    res[i][j] = res[i][j -1] && s2.charAt(j - 1) == s3.charAt(i + j - 1);
                else if(j == 0)
                    res[i][j] = res[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1);
                else
                    res[i][j] = res[i][j -1] && s2.charAt(j - 1) == s3.charAt(i + j - 1) || res[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1);
            }
            return res[s1.length()][s2.length()];
    }
}

public class IsInterleave {
    public static void main(String[] args){
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbcbcac";
        System.out.println(new Solution().isinterleave(s1, s2, s3));
    }
}
