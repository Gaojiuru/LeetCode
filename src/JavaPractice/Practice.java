package JavaPractice;

import java.math.BigDecimal;
import java.util.*;

enum Size{SMALL, MEDIUM, LARGE, EXTRA_LARGE};

public class Practice {
    public static void main(String[] args){
        int number = 10;
        System.out.println(Integer.toBinaryString(number >> 1));
        System.out.println(Integer.toBinaryString(number << 1));
        System.out.println(Integer.toBinaryString(number >>> 1));
        BigDecimal bigDouble = new BigDecimal(1.22);
        BigDecimal bigString = new BigDecimal("1.22");
        Double dou = Double.valueOf("1.22");
        BigDecimal bigD2S = new BigDecimal(dou);
        System.out.println(bigDouble + "\t" + bigString + "\t" + bigD2S);
        Size s = Size.MEDIUM;
        String all = String.join("/", "S", "M", "L", "XL");
        System.out.println(all);
        String greeting = "Hello";
        if(greeting.compareTo("Hello") == 0)
            System.out.println(greeting);
        int cpCount = greeting.codePointCount(0, greeting.length());
        System.out.println(cpCount);
        greeting = greeting.substring(0, 3) + "p";
        System.out.println(greeting);

        double x = 10000.0 / 3.0;
        System.out.println(x);
        System.out.printf("%8.2f", x);
        System.out.println();
        System.out.printf("%,.2f", 10000.0 / 3.0);
        System.out.println();
        System.out.printf("%,(.2f", 10000.0 / 3.0);
        System.out.println();
        System.out.printf("%1$s %2$tB %2$te, %2$tY", "Due data:", new Date());
        //System.out.println();
        //System.out.printf("%tc", new Date());
        System.out.println();
        System.out.printf("%s %tB %<te, %<tY", "Due Date:", new Date());
    }
}
