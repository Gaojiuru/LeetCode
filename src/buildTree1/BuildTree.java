package buildTree1;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution{
    public TreeNode buildTree(int[] inorder, int[] postorder){
        return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode buildTree(int[] inorder, int fromi, int toi, int[] postorder, int fromp, int top){
        if(fromi > toi || fromp > top)
            return null;
        TreeNode root = new TreeNode(postorder[top]);
        int i;
        for(i = fromi; i <= toi; i ++)
            if(inorder[i] == root.val)
                break;
        root.left = buildTree(inorder, fromi, i - 1, postorder, fromp, fromp + i - fromi - 1);
        root.right = buildTree(inorder, i + 1, toi, postorder, fromp + i - fromi, top - 1);
        return root;
    }
}

public class BuildTree {
    public static void main(String[] args){
        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};
        new Solution().buildTree(inorder, postorder);
    }
}
