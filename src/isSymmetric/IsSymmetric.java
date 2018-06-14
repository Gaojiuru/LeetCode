package isSymmetric;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution{
    public boolean isSymmetric(TreeNode root){
        return Helper(root, root);
    }

    private boolean Helper(TreeNode p, TreeNode q){
        if(p == null || q == null)
            return p == q;
        return p.val == q.val && Helper(p.left, q.right) && Helper(q.left, p.right);
    }
}

public class IsSymmetric {
    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        TreeNode l = new TreeNode(2);
        TreeNode r = new TreeNode(2);
        TreeNode ll = new TreeNode(3);
        TreeNode lr = new TreeNode(4);
        TreeNode rl = new TreeNode(4);
        TreeNode rr = new TreeNode(3);
        root.left = l;
        root.right = r;
        l.right = ll;
        r.right = rr;
        System.out.println(new Solution().isSymmetric(root));
    }
}
