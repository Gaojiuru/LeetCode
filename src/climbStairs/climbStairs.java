package climbStairs;

class Solution{
    public static int climbStairs(int n){
        int a = 1;
        int b = 1;
        while(n -- > 0)
            a = (b += a) - a;
        return a;
    }
}

public class climbStairs {
    public static void main(String[] args){
        System.out.println(Solution.climbStairs(3));
    }
}
