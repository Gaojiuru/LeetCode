package myAtoi;

class Solution{
    public static int myAtoi(String str){
        if(str == null || str.length() == 0)
            return 0;
        str = str.trim();
        int flag = 1, i = 0;
        if(str.charAt(0) == '+')
            i ++;
        if(str.charAt(0) == '-') {
            flag = -1;
            i ++;
        }
        double temp = 0;
        for(; i < str.length(); i ++){
            int x = str.charAt(i) - '0';
            if(x > 9 || x < 0)
                break;
            temp = temp * 10 + x;

            if(flag * temp > Integer.MAX_VALUE)
                return Integer.MAX_VALUE;
            if(flag * temp < Integer.MIN_VALUE)
                return Integer.MIN_VALUE;
        }

        return (int)(flag * temp);
    }
}

public class myAtoi {
    public static void main(String[] args) {
        String s = "2147483650";
        int x = Long.parseLong(s) > Integer.MAX_VALUE ? 1 : 0;
        System.out.println(x);
        System.out.println(Solution.myAtoi(s));
    }
}
