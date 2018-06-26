package recoverTree;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}

class Solution{
    TreeNode first = null;
    TreeNode second = null;
    TreeNode pre = new TreeNode(Integer.MIN_VALUE);
    public void recoverTree(TreeNode root){
        Traverse(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
    private void Traverse(TreeNode root){
        if(root == null)
            return;
        Traverse(root.left);
        if(first == null && pre.val >= root.val)
            first = pre;

        if(first != null && pre.val >= root.val)
            second = root;

        pre = root;

        Traverse(root.right);
    }
}

public class RecoverTree {
    public static void main(String[] args){
    }
}
