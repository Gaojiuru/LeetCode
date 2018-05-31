package grayCode;

import java.util.LinkedList;
import java.util.List;

class Solution{
    public List<Integer> grayCode(int n){
        List<Integer> result = new LinkedList<>();
        for(int i = 0; i < 1 << n; i ++)
            result.add(i ^ (i >> 1));
        return result;
    }
}

public class GrayCode {
    public static void main(String[] args){
        int n = 2;
        System.out.println(new Solution().grayCode(n));
    }
}
