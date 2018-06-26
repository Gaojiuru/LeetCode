package minDepth;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution{
    public int minDepth(TreeNode root){
        if(root == null)
            return 0;
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        if(left == 0 && right == 0)
            return 1;
        else if(left == 0 || right == 0)
            return left == 0 ? right + 1 : left + 1;
        else
            return left < right ? left + 1 : right + 1;
    }
}

public class MinDepth {
    public static void main(String[] args){
        TreeNode root = new TreeNode(3);
        TreeNode l = new TreeNode(9);
        TreeNode r = new TreeNode(20);
        TreeNode rl = new TreeNode(15);
        TreeNode rr = new TreeNode(7);
        root.left = l;
        root.right = r;
        r.left = rl;
        r.right = rr;
        TreeNode root1 = new TreeNode(1);
        TreeNode l1 = new TreeNode(2);
        root1.left = l1;
        System.out.println(new Solution().minDepth(root1));
    }
}
