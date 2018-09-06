package pathSum;

import java.util.LinkedList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution{
    public List<List<Integer>> pathSum(TreeNode root, int sum){
        List<List<Integer>> result = new LinkedList<>();
        List<Integer> list = new LinkedList<>();
        pathSum(result, list, root, sum);
        return result;
        }

    private void pathSum(List<List<Integer>> result, List<Integer> list, TreeNode root, int sum){
        if(root == null)
            return;
        list.add(root.val);
        if(root.val == sum && root.left == null && root.right == null){
            result.add(new LinkedList<>(list));
            list.remove(list.size() - 1);
            return;
        }
        else{
            pathSum(result, list, root.left, sum - root.val);
            pathSum(result, list, root.right, sum - root.val);
        }
        
        list.remove(list.size() - 1);
    }
}

public class PathSum {
    public static void main(String[] args){
        TreeNode root = new TreeNode(5);
        TreeNode l = new TreeNode(4);
        TreeNode r = new TreeNode(8);
        TreeNode ll = new TreeNode(11);
        TreeNode lll = new TreeNode(7);
        TreeNode llr = new TreeNode(2);
        TreeNode rl = new TreeNode(13);
        TreeNode rr = new TreeNode(4);
        TreeNode rrl = new TreeNode(5);
        TreeNode rrr = new TreeNode(1);
        root.left = l;
        root.right = r;
        l.left = ll;
        ll.left = lll;
        ll.right = llr;
        r.left = rl;
        r.right = rr;
        rr.left = rrl;
        rr.right = rrr;
        System.out.println(new Solution().pathSum(root, 22));
    }
}
