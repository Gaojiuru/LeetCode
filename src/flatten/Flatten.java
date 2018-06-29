package flatten;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution{
    public void flatten(TreeNode root){
        if(root == null)
            return;
        flatten(root.left);
        flatten(root.right);

        TreeNode node = root.left;
        if(node != null){
            while(node.right != null)
                node = node.right;
            node.right = root.right;
            root.right = root.left;
            root.left = null;
        }
    }
}

public class Flatten {
    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        TreeNode l = new TreeNode(2);
        TreeNode r = new TreeNode(5);
        TreeNode ll = new TreeNode(3);
        TreeNode lr = new TreeNode(4);
        TreeNode rr = new TreeNode(6);
        root.left = l;
        root.right = r;
        l.left = ll;
        l.right = lr;
        r.right = rr;
        new Solution().flatten(root);
    }
}
