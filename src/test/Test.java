package test;

import java.util.Scanner;

class Solution{
    public int num(int n){
        int sum = 0;
        if(n == 0)
            sum += 0;
        if(n == 1)
            sum += 10;
        if(n == 2)
            sum += 100;
        if(n > 2){
            sum += Math.pow(10, n);
            if(n - 1 >= 2)
                sum += 2 * (n - 2) * num(n - 1);
            int numBrackets = 0;
            if(n -2 >= 1)
                sum += 1;
        }
        return sum;
    }
}

public class Test {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(new Solution().num(n));
    }
}

