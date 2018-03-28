package Wangyi2;
//1=<x<=N,1=<y<=N,求x%y=k的整数对

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class wangyi2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        List<int[]> result = new LinkedList<>();
        for(int x = 1; x <= n; x ++) {
            for(int y = k; y <= n; y += x){
                if(y % x == k) {
                    int[] temp = {x, y};
                    result.add(temp);
                }

            }
        }
        for(int[] s: result){
            System.out.print(s[0] + " " + s[1]);
            System.out.println();
        }
    }
}
