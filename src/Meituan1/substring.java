package Meituan1;
//字符串S和模式串T，寻找S中S-T+1子串与T串的不同字符数总和

import java.util.Scanner;

public class substring {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S = sc.nextLine();
        String T = sc.nextLine();
        char[] s = S.toCharArray();
        char[] t = T.toCharArray();
        int result = 0;
        for (int i = 0; i < s.length - t.length + 1; i++) {
            for (int j = 0; j < t.length; j++) {
                if (s[i + j] != t[j])
                    result += 1;
            }
        }
        System.out.println(result);
    }
}
