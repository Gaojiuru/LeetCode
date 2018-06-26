package isBalanced;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution{
    public boolean isBalanced(TreeNode root){
        if(root == null)
            return true;
        return depthBalanced(root) != -1;
    }

    private int depthBalanced(TreeNode root){
        if(root == null)
            return 0;
        int left = depthBalanced(root.left);
        if(left == -1)
            return -1;
        int right = depthBalanced(root.right);
        if(right == -1 || Math.abs(left - right) > 1)
            return -1;
        return left > right ? left + 1 : right + 1;
    }
}

public class IsBalanced {
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
        System.out.println(new Solution().isBalanced(root));
    }
}
