package subsetsWithDup;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution{
    public List<List<Integer>> subsetWithDup(int[] nums){
        Arrays.sort(nums);
        List<List<Integer>> result = new LinkedList<>();
        result.add(new LinkedList<>());
        int size = 0;
        int startIndex;
        for(int i = 0; i < nums.length; i ++){
            startIndex = i >= 1 && nums[i] == nums[i - 1] ? size : 0;
            size = result.size();
            for(int j = startIndex; j < size; j ++){
                List<Integer> res = new LinkedList<>(result.get(j));
                res.add(nums[i]);
                result.add(res);
            }
        }
        return result;
    }
}

public class SubsetsWithDup {
    public static void main(String[] args){
        int[] nums = {1, 2, 2};
        System.out.println(new Solution().subsetWithDup(nums));
    }
}
