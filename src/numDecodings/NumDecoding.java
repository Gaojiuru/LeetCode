package numDecodings;

class Solution{
    public int numDecodings(String s){
        if(s == null || s.length() == 0)
            return 0;
        int[] num = new int[s.length() + 1];
        num[s.length()] = 1;
        num[s.length() - 1] = s.charAt(s.length() - 1) != '0' ? 1 : 0;
        for(int i = s.length() - 2; i >= 0; i --){
            if(s.charAt(i) == '0')
                continue;
            else
                num[i] = (Integer.parseInt(s.substring(i, i + 2)) <= 26) ?
                        num[i + 1] + num[i + 2] : num[i + 1];
        }
        return num[0];
    }
}

public class NumDecoding {
    public static void main(String[] args){
        String s = "12";
        System.out.println(new Solution().numDecodings(s));
    }
}
