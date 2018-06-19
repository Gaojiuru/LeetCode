package buildTree;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution{
    public TreeNode buildTree(int[] preorder, int[] inorder){
        return buildTree(preorder, 0, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int fromp, int[] inorder, int fromi, int toi){
        if(fromp > preorder.length || fromi > toi)
            return null;
        TreeNode root = new TreeNode(preorder[fromp]);
        int i;
        for(i = fromi; i <= toi; i ++)
            if(inorder[i] == root.val)
                break;
        root.left = buildTree(preorder, fromp + 1, inorder, fromi, i - 1);
        root.right = buildTree(preorder, fromp + i - fromi + 1, inorder, i + 1, toi);
        return root;
    }
}

public class BuildTree {
    public static void main(String[] args){
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        new Solution().buildTree(preorder, inorder);
    }
}
