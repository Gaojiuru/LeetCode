package sortedListToBST;

class ListNode{
    int val;
    ListNode next;
    ListNode(int x){
        val = x;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution{
    public TreeNode sortedListBST(ListNode head){
        if(head == null)
            return null;
        ListNode temp = head;
        int count = 0;
        while(temp != null){
            count ++;
            temp = temp.next;
        }
        return sortedListBST(new ListNode[]{head}, 0, count - 1);
    }

    private TreeNode sortedListBST(ListNode[] head, int low, int high){
        if(low > high)
            return null;
        int mid = low + (high - low) / 2;
        TreeNode left = sortedListBST(head, low, mid - 1);
        TreeNode root = new TreeNode(head[0].val);
        root.left = left;
        head[0] = head[0].next;
        root.right = sortedListBST(head, mid + 1, high);
        return root;
    }
}

public class SortedListToBST {
    public static void main(String[] args){
        ListNode head = new ListNode(-10);
        ListNode node1 = new ListNode(-3);
        ListNode node2 = new ListNode(0);
        ListNode node3 = new ListNode(5);
        ListNode node4 = new ListNode(9);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        TreeNode root = new Solution().sortedListBST(head);
        System.out.println(root.val);
        System.out.println(root.left.val);
        System.out.println(root.right.val);
    }
}
