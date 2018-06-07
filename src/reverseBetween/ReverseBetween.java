package reverseBetween;

class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x;
      }
}

class Solution{
    public ListNode reverseBetween(ListNode head, int m, int n){
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode pre = newHead;
        for(int i = 0; i < m - 1; i ++)
            pre = pre.next;
        ListNode p = pre.next;
        ListNode q = p.next;
        for(int i = 0; i < n - m; i ++){
            p.next = q.next;
            q.next = pre.next;
            pre.next = q;
            q = p.next;
        }
        return newHead.next;
    }
}

public class ReverseBetween {
    public static void main(String[] args){
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = null;
        head = new Solution().reverseBetween(head, 2, 4);
        while(head != null){
            System.out.print(head.val + "->");
            head = head.next;
        }
    }
}
