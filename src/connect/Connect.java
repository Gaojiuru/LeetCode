package connect;

import jdk.nashorn.api.tree.Tree;

class TreeLinkNode {
    int val;
    TreeLinkNode left, right, next;
    TreeLinkNode(int x) {
        val = x;
    }
 }

class Solution{
    public void connnect(TreeLinkNode root){
         if(root == null)
             return;
         for(TreeLinkNode node = root; node.left != null; node = node.left){
             for(TreeLinkNode cur = node; cur != null; cur = cur.next){
                 cur.left.next = cur.right;
                 if(cur.next != null)
                     cur.right.next = cur.next.left;
             }
         }
    }
}
public class Connect {
    public static void main(String[] args){
        TreeLinkNode root = new TreeLinkNode(1);
        TreeLinkNode l = new TreeLinkNode(2);
        TreeLinkNode r = new TreeLinkNode(3);
        TreeLinkNode ll = new TreeLinkNode(4);
        TreeLinkNode lr = new TreeLinkNode(5);
        TreeLinkNode rl = new TreeLinkNode(6);
        TreeLinkNode rr = new TreeLinkNode(7);
        root.left = l;
        root.right = r;
        l.left = ll;
        l.right = lr;
        r.left = rl;
        r.right = rr;
        new Solution().connnect(root);
    }
}
