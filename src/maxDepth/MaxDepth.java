package maxDepth;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution{
    public int maxDepth(TreeNode root){
        if(root == null)
            return 0;
        if(root.left == null && root.right == null)
            return 1;
        int Left = maxDepth(root.left);
        int Right = maxDepth(root.right);
        return Left > Right ? Left + 1: Right + 1;
    }
}

public class MaxDepth {
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
        System.out.println(new Solution().maxDepth(root));
    }
}
