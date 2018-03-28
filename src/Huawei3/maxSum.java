package Huawei3;
//求一个整型数组中连续一个或多个整数和的最大值

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class maxSum {
    public static void main(String[] args){
        String str = new Scanner(System.in).nextLine();
        String[] array = str.split(",");
        List<Integer> list = new LinkedList<>();
        for(int i = 0; i < array.length; i ++)
            list.add(Integer.valueOf(array[i]));
        //System.out.println(list);
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(Integer in : list){
            sum += in;
            if(sum > max)
                max = sum;
            if(sum < 0)
                sum = 0;

        }
        System.out.println(max);
    }
}
