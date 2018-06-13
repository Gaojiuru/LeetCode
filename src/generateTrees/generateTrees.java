package generateTrees;

import jdk.nashorn.api.tree.Tree;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x;
    }
}

class Solution{
    public List<TreeNode> generateTrees(int n){
        if(n < 1)
            return new ArrayList<>();
        return generate(1, n);
    }

    private List<TreeNode> generate(int s, int e){
        List<TreeNode> res = new ArrayList<>();
        if(s > e){
            res.add(null);
            return res;
        }
        List<TreeNode> left = new ArrayList<>();
        List<TreeNode> right = new ArrayList<>();
        for(int i = s; i <= e; i ++){
            left = generate(s, i - 1);
            right = generate(i + 1, e);
            for(TreeNode leftNode : left){
                for(TreeNode rightNode : right){
                    TreeNode root = new TreeNode(i);
                    root.left = leftNode;
                    root.right = rightNode;
                    res.add(root);
                }
            }
        }
        return res;
    }

}

public class generateTrees {
    public static void main(String[] args){
        List<TreeNode> res = new ArrayList<>();
        res = new Solution().generateTrees(3);
        for(TreeNode node : res){
            System.out.print(node.val + "\t");
        }
    }
}
