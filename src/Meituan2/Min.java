package Meituan2;
//给定一组数组，找出该组数字不能表示的最小的正整数

import java.util.*;

public class Min {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        char[] ch = str.toCharArray();
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < ch.length; i ++){
            if(map.containsKey(ch[i] - '0'))
                map.put(ch[i] - '0', map.get(ch[i] - '0') + 1);
            else
                map.put(ch[i] - '0', 1);
        }
        List<Map.Entry<Integer, Integer>> list_Data = new ArrayList<Map.Entry<Integer, Integer>>(map.entrySet());
        Collections.sort(list_Data, new Comparator<Map.Entry<Integer, Integer>>() {
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });

        if(map.size() < 10) {
            int i;
            for (i = 1; i < 10; i++) {
                if (!map.containsKey(i)) {
                    System.out.println(i);
                    break;
                }
            }
            if (i == 10)
                System.out.println(10);
        }
        else{
            int numz = map.get(0);
            int key = list_Data.get(0).getKey();
            key = key == 0 ? list_Data.get(1).getKey() : key;
            int value = map.get(key);
            int sum = 0;
            for(int j = 0; j < value; j ++){
                sum += key * Math.pow(10, j);
            }
            System.out.println(sum * Math.pow(10, numz + 1));
        }
    }
}
