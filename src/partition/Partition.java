package partition;

class ListNode {
      int val;
      ListNode next;
      ListNode(int x)
      {
          val = x;
      }
}

class Solution{
    public ListNode partition(ListNode head, int x){
        ListNode node1 = new ListNode(0);
        ListNode node2 = new ListNode(0);
        ListNode temp = head;
        ListNode p1 = node1;
        ListNode p2 = node2;
        while(temp != null){
            if(temp.val < x){
                p1.next = temp;
                p1 = p1.next;
            }
            else{
                p2.next = temp;
                p2 = p2.next;
            }
            temp = temp.next;
        }
        p2.next = null;
        p1.next = node2.next;
        return node1.next;
    }
}

public class Partition {
    public static void main(String[] args){
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(2);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;
        ListNode temp = new Solution().partition(head, 3);
        while(temp != null){
            System.out.print(temp.val + "->");
            temp = temp.next;
        }
    }
}
