package Package01;
//0/1背包问题
import java.util.Scanner;

public class package01 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int c = sc.nextInt();
        int n = sc.nextInt();
        int[] p = new int[n + 1];
        int[] w = new int[n + 1];
        int[] value = new int[2001];
        for(int i = 1; i <= n; i ++){
            w[i] = sc.nextInt();
            p[i] = sc.nextInt();
        }

        for(int i = 1; i <= n; i ++) {
            for (int j = c; j >= w[i]; j--)
                value[j] = Math.max(value[j - w[i]] + p[i], value[j]);
        }

        System.out.println(value[c]);
    }
}
