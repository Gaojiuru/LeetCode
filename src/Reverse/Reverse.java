package Reverse;

class Solution{
    public static int reverse(int x){
        int flag = x < 0 ? -1 : 1;
        long res = 0;
        x = Math.abs(x);
        while(x > 0){
            res = res * 10 + x % 10;
            x /= 10;
        }
        if(flag * res > Integer.MAX_VALUE || flag * res < Integer.MIN_VALUE)
            return 0;
        else return Integer.parseInt(String.valueOf(flag * res));
    }
}

public class Reverse {
    public static void main(String[] args) {
        int x = 123;
        int y = -123;
        int z = 1534236469;
        System.out.println(Solution.reverse(x));
        System.out.println(Solution.reverse(y));
        System.out.println(Solution.reverse(z));
    }
}
