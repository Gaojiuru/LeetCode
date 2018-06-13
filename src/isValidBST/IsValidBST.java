package isValidBST;

import jdk.nashorn.api.tree.Tree;

import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}

class Solution{
    public boolean isValidBST(TreeNode root){
        if(root == null)
            return true;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        while(root != null || !stack.isEmpty()){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(pre != null && pre.val >= root.val)
                return false;
            pre = root;
            root = root.right;
        }
        return true;
    }
}

class Solution1{
    public boolean isValidBST(TreeNode root){
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode root, long min, long max){
        if(root == null)
            return true;
        if(root.val >= max || root.val <= min)
            return false;
        return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
    }
}

public class IsValidBST {
    public static void main(String[] args){
        TreeNode root = new TreeNode(5);
        TreeNode l = new TreeNode(1);
        TreeNode r = new TreeNode(4);
        TreeNode rl = new TreeNode(3);
        TreeNode rr = new TreeNode(6);
        root.left = l;
        root.right = r;
        r.left = rl;
        r.right = rr;
        System.out.println(new Solution1().isValidBST(root));
    }
}

