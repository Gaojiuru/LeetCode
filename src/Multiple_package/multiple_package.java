package Multiple_package;
//多重背包

import java.util.Scanner;

public class multiple_package {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int n1 = 1;
        int[] v = new int[10001];
        int[] w = new int[10001];
        for(int i = 1; i <= n; i ++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            int s = sc.nextInt();
            int t = 1;
            while( s >= t){
                v[n1] = x * t;
                w[n1] = y * t;
                s -= t;
                t *= 2;
                n1 ++;
            }
            v[n1] = x * s;
            w[n1] = y * s;
            n1 ++;
        }

        int[] value = new int[6001];
        for(int i = 1; i <= n1; i ++) {
            for (int j = m; j >= v[i]; j --)
                value[j] = Math.max(value[j - v[i]] + w[i], value[j]);
        }

        System.out.println(value[m]);
    }
}
