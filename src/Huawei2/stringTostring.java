package Huawei2;

import java.util.HashMap;
import java.util.Scanner;

public class stringTostring {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        HashMap<Character, Character> map = new HashMap<>(26);
        map.put('a', 'q'); map.put('b', 'w'); map.put('c', 'e'); map.put('d', 'r');
        map.put('e', 't'); map.put('f', 'y'); map.put('g', 'u'); map.put('h', 'i');
        map.put('i', 'o'); map.put('j', 'p'); map.put('k', 'a'); map.put('l', 's');
        map.put('m', 'd'); map.put('n', 'f'); map.put('o', 'g'); map.put('p', 'h');
        map.put('q', 'j'); map.put('r', 'k'); map.put('s', 'l'); map.put('t', 'z');
        map.put('u', 'x'); map.put('v', 'c'); map.put('w', 'v'); map.put('x', 'b');
        map.put('y', 'n'); map.put('z', 'm');

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < str.length(); i ++){
            char temp = str.charAt(i);
            if(temp == ' ')
                sb.append(' ');
            else if(temp >= 'a' && temp <= 'z')
                sb.append(map.get(temp));
            else{
                char ch = Character.toLowerCase(temp);
                sb.append(Character.toUpperCase(map.get(ch)));
            }

        }
        System.out.println(sb.toString());
    }
}
