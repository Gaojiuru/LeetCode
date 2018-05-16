package subSet;

import java.util.LinkedList;
import java.util.List;

class Solution{
    List<List<Integer>> result = new LinkedList<>();
    public List<List<Integer>> subsets(int[] nums){
        List<Integer> list = new LinkedList<>();
        backTracing(list, 0, nums);
        return result;

    }
    private void backTracing(List<Integer> list, int from, int[] nums){
        result.add(new LinkedList<>(list));

        for(int i = from; i < nums.length; i ++){
            list.add(nums[i]);
            backTracing(list, i + 1, nums);
            list.remove((Integer)nums[i]);
        }
    }
}

class Solution2{
    public List<List<Integer>> subsets(int[] nums){
        List<List<Integer>> result = new LinkedList<>();
        result.add(new LinkedList<>());
        for(Integer n : nums){
            int size = result.size();
            for(int i = 0; i < size; i ++){
                List<Integer> list = new LinkedList<>(result.get(i));
                list.add(n);
                result.add(list);
            }
        }
        return result;
    }
}

public class Subset {
    public static void main(String[] args){
        int[] nums = {1, 2, 3};
        System.out.println(new Solution2().subsets(nums));
    }
}
