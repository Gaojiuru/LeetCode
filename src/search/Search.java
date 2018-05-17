package search;

import java.util.function.BinaryOperator;

class Solution{
    public boolean search(int[] nums, int target){
        if(nums.length < 1)
            return false;
        if(nums.length == 1)
            return nums[0] == target ? true : false;
        int i;
        for(i = 1; i < nums.length; i ++){
            if(nums[i - 1] > nums[i])
                break;
        }

        if(nums[i - 1] == target)
            return true;
        if(i - 1 == nums.length - 1)
            return binarySearch(nums, 0, nums.length - 1, target);
        return binarySearch(nums, 0, i - 2, target) || binarySearch(nums, i, nums.length - 1, target);
    }

    private boolean binarySearch(int[] nums, int from, int to, int target){
        while(from <= to){
            int mid = (from + to) / 2;
            if(nums[mid] < target)
                from = mid + 1;
            else if(nums[mid] > target)
                to = mid - 1;
            else
                return true;
        }
        return false;
    }
}

public class Search {
    public static void main(String[] args){
        int[] nums = {2, 2, 2, 0, 1};
        int target = 0;
        System.out.println(new Solution().search(nums, target));
    }
}
