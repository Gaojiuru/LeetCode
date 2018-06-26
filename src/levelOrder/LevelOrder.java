package levelOrder;

import java.util.LinkedList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution{
    public List<List<Integer>> levelOrder(TreeNode root){
        List<List<Integer> > result = new LinkedList<>();
        LevelOrder(root, 0, result);
        return result;
    }

    private void LevelOrder(TreeNode root, int height, List<List<Integer>> result){
        if(root == null)
            return;
        if(result.size() == height)
            result.add(height, new LinkedList<>());
        result.get(height).add(root.val);
        LevelOrder(root.left, height + 1, result);
        LevelOrder(root.right, height + 1, result);
    }
}

public class LevelOrder {
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
        System.out.println(new Solution().levelOrder(root));
    }
}
