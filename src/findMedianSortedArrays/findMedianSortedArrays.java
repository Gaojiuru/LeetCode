package findMedianSortedArrays;

import java.util.Arrays;

class Solution{
    public static double findMedianSortedArrays(int[] nums1, int[] nums2){
        int m = nums1.length;
        int n = nums2.length;
        int total = m + n;
        if(total % 2 != 0)
            return findKth(nums1, m, nums2, n, total / 2 + 1);
        else
            return (findKth(nums1, m, nums2, n, total / 2) + findKth(nums1, m, nums2, n, total / 2 + 1)) / 2.0;
    }

    public static int findKth(int[] a, int m, int[] b, int n, int k){
        if(m > n)
            return findKth(b, n, a, m, k);
        if(m == 0)
            return b[k-1];
        if(k == 1)
            return Math.min(a[0], b[0]);

        int len1 = Math.min(k / 2, m);
        int len2 = k - len1;

        if(a[len1 - 1] < b[len2 -1]){
            int[] pa = Arrays.copyOfRange(a,len1, m);
            return findKth(pa, m - len1, b, n, k - len1);
        }
        if(a[len1 - 1] > b[len2 -1]){
            int[] pb = Arrays.copyOfRange(b,len2, n);
            return findKth(a, m, pb, n - len2, k - len2);
        }
        else return a[len1 - 1];
    }
}

public class findMedianSortedArrays {
    public static void main(String[] args) {
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        double media = Solution.findMedianSortedArrays(nums1, nums2);
        System.out.println(media);
    }
}
