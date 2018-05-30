package merge;

class Solution{
    public void merge(int[] nums1, int m, int[] nums2, int n){
        int k = m + n - 1;
        int i = m - 1;
        int j = n - 1;
        while(i >= 0 && j >= 0){
            if(nums1[i] > nums2[j])
                nums1[k --] = nums1[i --];
            else
                nums1[k --] = nums2[j --];
        }
        while(j >= 0)
            nums1[k --] = nums2[j --];
        for(Integer num : nums1)
            System.out.print(num + "\t");
    }
}

public class Merge {
    public static void main(String[] args){
        int m = 3;
        int n = 3;
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        new Solution().merge(nums1, m, nums2, n);
    }
}
