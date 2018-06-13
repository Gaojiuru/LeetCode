package isSameTree;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){
        val = x;
    }
}

class Solution{
    public boolean isSameTree(TreeNode p, TreeNode q){
        if(p == null && q == null)
            return true;
        if(p == null || q == null)
            return false;
        if(p.val == q.val)
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        return false;
    }

}

public class IsSameTree {
    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        TreeNode l = new TreeNode(2);
        TreeNode r = new TreeNode(3);
        root.left = l;
        root.right = r;
        TreeNode root1 = new TreeNode(1);
        TreeNode l1 = new TreeNode(3);
        TreeNode r1 = new TreeNode(0);
        root1.left = l1;
        root1.right = r1;
        System.out.println(new Solution().isSameTree(root, root1));
    }
}
