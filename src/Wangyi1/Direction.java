package Wangyi1;
//初始方向N，左转或右转，求最终方向

import java.util.Scanner;

public class Direction {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = sc.next();
        int countl = 0, countr = 0;
        for(int i = 0; i < n; i ++){
            if(str.charAt(i) == 'L')
                countl ++;
            else
                countr ++;
        }
        int res = (countr - countl) % 4;
        char[] directionr = {'N', 'E', 'S', 'W'};
        char[] directionl = {'N', 'W', 'S', 'E'};
        if(res >= 0)
            System.out.println(directionr[res]);
        else
            System.out.println(directionl[res]);
    }
}
