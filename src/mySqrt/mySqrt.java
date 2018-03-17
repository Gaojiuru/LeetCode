package mySqrt;

class Solution{
    public static int mySqrt(int x) {
        long r = x;
        while (r * r > x)
            r = (r + x / r) / 2;
        return (int) r;
    }
}

public class mySqrt {
    public static void main(String[] args){
        System.out.println(Solution.mySqrt(8));
    }
}
