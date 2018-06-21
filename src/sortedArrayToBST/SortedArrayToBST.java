package sortedArrayToBST;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution{
    public TreeNode sortedArrayToBST(int[] nums){
        return buildBST(0, nums.length, nums);
    }

    private TreeNode buildBST(int start, int end, int[] nums){
        if(start > end)
            return null;
        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = buildBST(start, mid - 1, nums);
        root.right = buildBST(mid + 1, end, nums);
        return root;
    }
}

public class SortedArrayToBST {
    public static void main(String[] args){
        int[] nums = {-10, -3, 0, 5, 9};
        new Solution().sortedArrayToBST(nums);
    }
}
