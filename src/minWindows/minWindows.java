package minWindows;

class Solution{
    public String minWindows(String s, String t){
        String str = "";
        int[] needToFind = new int[256];
        for(int i = 0; i < t.length(); i ++)
            needToFind[t.charAt(i)] ++;

        int[] hasFound = new int[256];
        int minWindowLen = Integer.MAX_VALUE;
        int count = 0;
        for(int begin = 0, end = 0; end < s.length(); end ++){
            if(needToFind[s.charAt(end)] == 0)
                continue;
            hasFound[s.charAt(end)] ++;
            if(hasFound[s.charAt(end)] <= needToFind[s.charAt(end)])
                count ++;
            if(count >= t.length()){
                while(needToFind[s.charAt(begin)] == 0 || hasFound[s.charAt(begin)] > needToFind[s.charAt(begin)]){
                    if(hasFound[s.charAt(begin)] > needToFind[s.charAt(begin)])
                        hasFound[s.charAt(begin)] --;
                    begin ++;
                }

                int windowLen = end - begin + 1;
                if(windowLen < minWindowLen){
                    minWindowLen = windowLen;
                    str = s.substring(begin, end + 1);
                }
            }
        }

        return str;
    }
}

public class minWindows {
    public static void main(String[] args){
        String s = "a";
        String t = "aa";
        System.out.println(new Solution().minWindows(s, t));
    }
}
