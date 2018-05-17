package removeDuplicates;

class Solution{
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for(Integer n : nums)
            if (i < 2 || n > nums[i - 2])
                nums[i ++] = n;
        return i;
    }
}

public class RemoveDuplicates {
    public static void main(String[] args){
        //int[] nums = {1, 1, 1, 2, 2, 3};
        int[] nums = {0, 0, 1, 1, 1, 1, 2, 3, 3};
        System.out.println(new Solution().removeDuplicates(nums));
    }
}
