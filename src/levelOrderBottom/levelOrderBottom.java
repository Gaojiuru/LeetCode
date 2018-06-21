package levelOrderBottom;

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
    public List<List<Integer>> levelOrderBottom(TreeNode root){
        List<List<Integer>> result = new LinkedList<>();
        if(root == null)
            return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            List<Integer> list = new LinkedList<>();
            int size = queue.size();
            for(int i = 0; i < size; i ++){
                if(queue.peek().left != null)
                    queue.offer(queue.peek().left);
                if(queue.peek().right != null)
                    queue.offer(queue.peek().right);
                list.add(queue.poll().val);
            }
            result.add(0, list);
        }
        return result;
    }
}

public class levelOrderBottom {
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
        System.out.println(new Solution().levelOrderBottom(root));
    }
}
