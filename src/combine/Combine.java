package combine;

import java.util.LinkedList;
import java.util.List;

class Solution{
    List<List<Integer>> result = new LinkedList<>();
    public List<List<Integer>> combine(int n, int k){
        List<Integer> list = new LinkedList<>();
        backTracing(list, 1, n, k);
        return result;
    }
    private void backTracing(List<Integer> list, int from, int n, int k){
        if(list.size() == k) {
            result.add(new LinkedList<>(list));
            return;
        }

        for(int i = from; i <= n; i ++){
            list.add(i);
            backTracing(list, i + 1, n, k);
            list.remove((Integer)i);
        }
    }
}

public class Combine {
    public static void main(String[] args){
        int n = 4;
        int k= 2;
        System.out.println(new Solution().combine(n, k));
    }
}
