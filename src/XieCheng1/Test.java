package XieCheng1;

import java.util.Scanner;

public class Test {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Long num = sc.nextLong();
        int count = 0;
        while(num != 0) {
            if ((num & 1) == 1)
                count++;
            num = num >>> 1;
        }
        System.out.println(count);
    }
}
