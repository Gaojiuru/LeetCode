/*Given nums = [2, 7, 11, 15], target = 9, Because nums[0] + nums[1] = 2 + 7 = 9, return [0, 1].*/

package twoSum;

import java.util.Map;
import java.util.HashMap;

class Method {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                result[1] = i;
                result[0] = map.get(nums[i]);
                return result;
            }
            map.put(target - nums[i], i);
        }
        return result;
    }
}

public class twoSum {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 22;
        int[] result = Method.twoSum(nums, target);
        for (int i = 0; i < result.length; i++)
            System.out.println(result[i]);
    }
}
