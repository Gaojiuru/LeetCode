package Huawei1;

import java.util.Scanner;

public class maxEnegy {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[] num = new int[21];
        for(int i = 0; i < 21; i ++)
            num[i] = sc.nextInt();
        int max = 0;
        int index = 0;
        for(int i = 0; i < 18; i ++){
            int sum = num[i];
            for(int j = i + 1; j < i + 4; j ++){
                sum += num[j];
            }
            if(sum > max){
                max = sum;
                index = i;
            }
        }
        System.out.println(index);
    }
}
