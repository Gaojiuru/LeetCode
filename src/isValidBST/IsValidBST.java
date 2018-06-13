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
        System.out.println(new Solution().isValidBST(root));
    }
}

