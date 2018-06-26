package hasPathSum;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution{
    public boolean hasPathSum(TreeNode root, int sum){
        if(root == null)
            return false;
        if(root.val == sum && root.left == null && root.right == null)
            return true;
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}

public class HasPathSum {
    public static void main(String[] args){
        TreeNode root = new TreeNode(5);
        TreeNode l = new TreeNode(4);
        TreeNode r = new TreeNode(8);
        TreeNode ll = new TreeNode(11);
        TreeNode lll = new TreeNode(7);
        TreeNode llr = new TreeNode(2);
        TreeNode rl = new TreeNode(13);
        TreeNode rr = new TreeNode(4);
        TreeNode rrr = new TreeNode(1);
        root.left = l;
        root.right = r;
        l.left = ll;
        ll.left = lll;
        ll.right = llr;
        r.left = rl;
        r.right = rr;
        rr.right = rrr;
        System.out.println(new Solution().hasPathSum(root, 22));
    }
}
