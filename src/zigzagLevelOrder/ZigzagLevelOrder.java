package zigzagLevelOrder;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution{
    public List<List<Integer>> zigzagLevelOrder(TreeNode root){
        List<List<Integer>> result = new LinkedList<>();
        if(root == null)
            return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int count = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new LinkedList<>();
            while(size -- > 0){
                TreeNode node = queue.poll();
                if(node.left != null)
                    queue.add(node.left);
                if(node.right != null)
                    queue.add(node.right);
                if(count % 2 == 0)
                    list.add(0, node.val);
                else
                    list.add(list.size(), node.val);
            }
            count ++;
            result.add(list);
        }
        return result;
    }

}

public class ZigzagLevelOrder {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode l = new TreeNode(9);
        TreeNode r = new TreeNode(20);
        TreeNode rl = new TreeNode(15);
        TreeNode rr = new TreeNode(7);
        root.left = l;
        root.right = r;
        r.left = rl;
        r.right = rr;
        System.out.println(new Solution().zigzagLevelOrder(root));
    }
}
